package com.example.test101.controller;

import com.example.test101.entity.PersonForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/person/results").setViewName("results");
    }

    @GetMapping("/person")
    public String showForm(PersonForm personForm) {

        return "person/form";
    }

    @PostMapping("/person")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "person/form";
        }
        return "redilect:/results";
    }
}
