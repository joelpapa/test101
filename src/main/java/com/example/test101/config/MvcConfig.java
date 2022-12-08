package com.example.test101.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/members/login").setViewName("/members/login");
        registry.addViewController("/members/new").setViewName("/members/new");
        registry.addViewController("/board/list").setViewName("/board/list");
    }
}
