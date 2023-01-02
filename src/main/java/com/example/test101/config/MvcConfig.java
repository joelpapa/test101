package com.example.test101.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{

    @Value("${uploadPath}")
    String uploadPath;
    public void addReSourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/logout_success").setViewName("logout_success");
        registry.addViewController("/members/login").setViewName("/members/Login");
        registry.addViewController("/members/new").setViewName("/members/new");
        registry.addViewController("/category/list").setViewName("/category/list");

//        registry.addViewController("/board/list").setViewName("/board/list");
//        registry.addViewController("/board/write").setViewName("/board/write");
//        registry.addViewController("/board/writego").setViewName("/board/writego");




    }
}
