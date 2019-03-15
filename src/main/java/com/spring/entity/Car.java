package com.spring.entity;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car(){
        System.out.println("car..........Construction");
    }

    public void init(){
        System.out.println("car............init");
    }

    public void destory(){
        System.out.println("car.............destory");
    }

}
