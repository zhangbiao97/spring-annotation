package com.spring;

import com.spring.config.SpringConfigOfAutowired;
import com.spring.entity.Boss;
import com.spring.entity.Car;
import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigOfAutowired.class);
        //UserService userService = (UserService) context.getBean("userService");
        Boss boss = context.getBean(Boss.class);
        Car car = context.getBean(Car.class);
        System.out.println(boss);
        System.out.println(car);
        System.out.println(context);
    }

}
