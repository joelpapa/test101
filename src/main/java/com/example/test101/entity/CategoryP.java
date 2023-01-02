package com.example.test101.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "category_p")
@Getter
@Setter
public class CategoryP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ctgr_id")
    private Integer id;

    private String name;

    @Column(name="use_yn")
    private Boolean useyn;


    @OneToMany(mappedBy = "categoryP", cascade = CascadeType.ALL)
    private List<CategoryC> catetoriesc = new ArrayList<>();

    public CategoryP() {

    }

    public CategoryP(String name){
        this.name = name;
        this.useyn = Boolean.TRUE;
    }


}
