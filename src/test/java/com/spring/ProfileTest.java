package com.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.spring.config.SpringConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;

public class ProfileTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");
        context.register(SpringConfigOfProfile.class);
        context.refresh();
        String[] beanNamesForType = context.getBeanNamesForType(DruidDataSource.class);
        Arrays.asList(beanNamesForType)
                .forEach(System.out::println);
    }

}
