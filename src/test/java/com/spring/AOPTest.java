package com.spring;

import com.spring.aop.MathCalculate;
import com.spring.config.SpringConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigOfAOP.class);
        MathCalculate mathCalculate = context.getBean(MathCalculate.class);
        mathCalculate.div(1,1);
    }


}
