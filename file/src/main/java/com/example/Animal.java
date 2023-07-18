package com.example;

import lombok.Setter;

@Setter
public class Animal {

    private String name;


    private String method(){
        return name;
    }

}
