package com.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Boss {


    private Car car;

    public Boss(){}

    public Boss(Car car){
        System.out.println("Boss Construction");
        this.car=car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
