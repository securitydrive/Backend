package com.example.demo.config;

import com.example.demo.service.user.impl.UserSecurityLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <pre>
 *
 * </pre>
 * @author tensor
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class MultiHttpSecurityConfiguration {

    @Configuration
    @Order(1)
    public static class FormLoginWebSecurityConfigurerAdaper extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserSecurityLogin userSecurityLogin;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userSecurityLogin);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic()
                    .and()
                    .antMatcher("/atta/**").authorizeRequests().anyRequest().permitAll()
                    .and()
                    .formLogin().loginPage("/").loginProcessingUrl("/login").permitAll()
                    .and()
                    .logout()
                    .clearAuthentication(true)
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true);
        }
    }

    @Configuration
    public static class AppLoginWebSecurityConfigurerAdaper extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserSecurityLogin userSecurityLogin;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userSecurityLogin);
        }

        /**
         * @param http
         * @throws Exception
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                    .authorizeRequests()
                    .antMatchers("/oauth/*").permitAll()
                    .anyRequest().authenticated();
            // @formatter:on
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            AuthenticationManager manager = super.authenticationManagerBean();
            return manager;
        }
    }
}
