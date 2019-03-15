package com.spring;

import static org.junit.Assert.assertTrue;

import com.spring.config.SpringConfig;
import com.spring.config.SpringDAOConfig;
import com.spring.entity.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private AnnotationConfigApplicationContext context=null;

    {
        context=new AnnotationConfigApplicationContext(SpringConfig.class);
    }


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testSpringDAOConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDAOConfig.class);
        Arrays.asList(context.getBeanDefinitionNames())
                .forEach(System.out::println);
    }

    @Test
    public void testSpringConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("IOC容器创建完成......");
        Person person1 = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);
        System.out.println(person1 == person2);
    }

    @Test
    public void testConditional(){
        Map<String, Person> persons = context.getBeansOfType(Person.class);
        persons.forEach((k,v) -> System.out.println(k+"\t"+v));
    }

    public void testPrint(AnnotationConfigApplicationContext context){
        Arrays.asList(context.getBeanDefinitionNames())
                .forEach(System.out::println);
    }

    @Test
    public void testImport(){
        testPrint(context);
    }

    @Test
    public void testFactoryBean(){
        Object colorFactoryBean = context.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
    }

}
