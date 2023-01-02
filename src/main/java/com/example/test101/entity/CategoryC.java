package com.example.test101.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category_c")
@Getter
@Setter
public class CategoryC {

    @Id
    @Column(name="ctgr_dtl_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dtlname" )
    private String name;

    @Column(name="use_yn")
    private Boolean useyn;

    @ManyToOne
    @JoinColumn(name="ctgr_id")
    private CategoryP categoryP;


    public CategoryC(){}
}
