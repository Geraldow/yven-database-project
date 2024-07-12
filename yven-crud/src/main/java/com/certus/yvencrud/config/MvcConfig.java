package com.certus.yvencrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("principal");
        registry.addViewController("/principal").setViewName("principal");
        registry.addViewController("/inicio").setViewName("principal");
        registry.addViewController("/registro").setViewName("registro");
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/error").setViewName("error");
    }

}
