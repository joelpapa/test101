package com.example.test101.controller;

import com.example.test101.entity.CategoryC;
import com.example.test101.entity.CategoryP;
import com.example.test101.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/category")
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

 @GetMapping("/list")
    public String getCategoryAll(Model model) {
     List<CategoryP> categoryPList =  categoryService.getAllCategory();
     model.addAttribute("categoryPList", categoryPList) ;
     return "/category/categoryplist";
 }

  @GetMapping("/list/{id}")
    public String getChildren(Model model, @PathVariable("id") CategoryP ctgrid) {
     List<CategoryC> categoryCList = categoryService.getAllChild(ctgrid);
     model.addAttribute("categoryCList", categoryCList);
     return "/category/categoryclist";
  }

    @GetMapping("/collapse")
    public String getAll(Model model) {
        List<CategoryP> categoryPList = categoryService.getAllCategory();
        List<CategoryC> categoryCList = categoryService.getAll();
        model.addAttribute("categoryPList", categoryPList);
        model.addAttribute("categoryCList", categoryCList);
        return "/category/categorycollapse";
    }
}
