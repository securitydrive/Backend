package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tensor
 */
@Configuration
public class WebMvcAdaperConfiguration extends WebMvcConfigurerAdapter {

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atta/login").setViewName("manage");
        registry.addViewController("/atta/index").setViewName("manage");
        registry.addViewController("/atta/device").setViewName("charts");
        registry.addViewController("/atta/node/manage").setViewName("device");
        registry.addViewController("/atta/node/distribute").setViewName("elements");
        registry.addViewController("/atta/notify").setViewName("notifications");
        registry.addViewController("/atta/profile").setViewName("page-profile");
        registry.addViewController("/atta/lock").setViewName("page-lockscreen");
        registry.addViewController("/atta/admin").setViewName("panels");
        super.addViewControllers(registry);
    }

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptors()).addPathPatterns("/atta/").excludePathPatterns("/atta/login");
        super.addInterceptors(registry);
    }

    private static class MyInterceptors implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            return false;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        }
    }
}
