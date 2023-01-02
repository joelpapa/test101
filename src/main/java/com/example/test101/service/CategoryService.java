package com.example.test101.service;

import com.example.test101.entity.CategoryC;
import com.example.test101.entity.CategoryP;
import com.example.test101.repository.CategorycRepository;
import com.example.test101.repository.CategorypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategorypRepository categorypRepository;

    @Autowired
    private CategorycRepository categorycRepository;

    public List<CategoryP> getAllCategory() {
        return categorypRepository.findAll();
    }

    public Optional<CategoryP> getCategoryp(Integer  ctgrid){

        return categorypRepository.findById(ctgrid);
    }

    public List<CategoryC> getAllChild(CategoryP ctgr_id) {
        return categorycRepository.findByCategoryP(ctgr_id);
    }

    public List<CategoryC> getAll() {
        return categorycRepository.findAll();
    }
}
