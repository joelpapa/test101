package com.example.test101.entity;


import jakarta.validation.constraints.NotNull;

public class Greeting {


    @NotNull
    private String id;


    private String password;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }
}
