package com.example.test101.repository;

import com.example.test101.entity.CategoryC;
import com.example.test101.entity.CategoryP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorycRepository extends JpaRepository<CategoryC,  Integer> {


    List<CategoryC> findByCategoryP(CategoryP ctgr_id);
}
