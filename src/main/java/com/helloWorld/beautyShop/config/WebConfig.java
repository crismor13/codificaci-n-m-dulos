package com.helloWorld.beautyShop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Register the LoginInterceptor and define the URL patterns it should apply to
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // Apply to all paths
                .excludePathPatterns("/login", "/register", "/404", "/static/**", "/css/**"); // Exclude login, register, and error pages
    }
}

