package com.spring;

import com.spring.tx.SpringConfigOfTX;
import com.spring.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigOfTX.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.insertBook();


    }

}
