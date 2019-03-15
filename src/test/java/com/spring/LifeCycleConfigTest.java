package com.spring;

import com.spring.config.LifeCycleConfig;
import com.spring.entity.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleConfigTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        //context.getBean("car");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
        context.close();
    }



}
