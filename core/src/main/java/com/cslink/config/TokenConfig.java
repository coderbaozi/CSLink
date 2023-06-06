package com.cslink.config;

import com.cslink.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TokenConfig  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // register interceptor
        InterceptorRegistration registration = registry.addInterceptor(new TokenInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(
                "/signup",
                "/signin",
                "/getcode",
                "/existUserName/**",
                "/existEmail/**",
                "/getArticle",
                "/getArticleList",
                "/getTags",
                "/getComment/*",
                "/getUserName",
                "/getArticleCount"
        );
    }
}
