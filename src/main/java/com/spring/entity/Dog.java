package com.spring.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {


    public Dog(){
        System.out.println("dog.........construction");
    }

    @PostConstruct
    public void init(){
        System.out.println("dog...........@PostConstruct");
    }

    @PreDestroy
    public void destory(){
        System.out.println("dog............@PreDestroy");
    }

}
