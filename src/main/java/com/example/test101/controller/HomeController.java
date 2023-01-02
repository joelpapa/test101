package com.example.test101.controller;

import com.example.test101.entity.CategoryC;
import com.example.test101.entity.CategoryP;
import com.example.test101.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller

public class HomeController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("")
    public String home(Model model) {
        List<CategoryP> categoryPList = categoryService.getAllCategory();
        List<CategoryC> categoryCList = categoryService.getAll();
        model.addAttribute("categoryPlist",categoryPList);
        model.addAttribute("categoryCList", categoryCList);
        return "index";
    }
}
