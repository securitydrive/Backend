package com.example.demo.config;

import com.example.demo.service.user.impl.UserSecurityLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.*;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 *
 * </pre>
 * @author tensor
 */
@Configuration
public class OAuth2ServerConfiguration {

    public static final String DEMO_RESOURCE_ID = "test";

    @Component
    protected static class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

        /**
         * Commences an authentication scheme.
         * <p>
         * <code>ExceptionTranslationFilter</code> will populate the <code>HttpSession</code>
         * attribute named
         * <code>AbstractAuthenticationProcessingFilter.SPRING_SECURITY_SAVED_REQUEST_KEY</code>
         * with the requested target URL before calling this method.
         * <p>
         * Implementations should modify the headers on the <code>ServletResponse</code> as
         * necessary to commence the authentication process.
         *
         * @param request       that resulted in an <code>AuthenticationException</code>
         * @param response      so that the user agent can begin authentication
         * @param authException that caused the invocation
         */
        @Override
        public void commence(HttpServletRequest request,
                             HttpServletResponse response,
                             AuthenticationException authException) throws IOException, ServletException {
            response.sendRedirect("/oauth/error");
        }
    }

    @Configuration
    @EnableResourceServer
    protected static class ResourceSecurityConfiguration extends ResourceServerConfigurerAdapter {

        @Autowired private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

        /**
         *
         * @param resources
         */
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
        }

        /**
         * 配置需要进行 token 认证的 restful_api
         * @param http
         * @throws Exception
         */
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .exceptionHandling()
                    .authenticationEntryPoint(customAuthenticationEntryPoint)
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/test/**", "/api/**").authenticated();
        }

    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private UserSecurityLogin userSecurityLogin;
        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        RedisConnectionFactory redisConnectionFactory;

        /**
         * 配置Oauth2的client端
         * 设置授权方式 {password，refresh_token}
         * 设置权限范围 scope
         * 设置client_secret
         * 设置token过期时间
         *
         * @param clients
         * @throws Exception
         */
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory().withClient("client")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("all")
                    .authorities("client")
                    .secret("123456")
                    .refreshTokenValiditySeconds(360);
        }

        /**
         * 配置相关token的存储信息以及设置用户信息验证方式{userDetailsService}
         *
         * @param endpoints
         * @throws Exception
         */
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(new RedisTokenStore(redisConnectionFactory))
                    .authenticationManager(authenticationManager)
                    .userDetailsService(userSecurityLogin)
                    .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                    .reuseRefreshTokens(true);
        }

        /**
         * 允许信息以表单的形式提交
         *
         * @param oauthServer
         * @throws Exception
         */
        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer.allowFormAuthenticationForClients();
        }
    }

}
