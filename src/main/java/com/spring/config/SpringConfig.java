package com.spring.config;

import com.spring.custom.*;
import com.spring.entity.Color;
import com.spring.entity.Person;
import org.springframework.context.annotation.*;

/**
 * @Import 注解：导入组件,id默认是组件的全类名
 */
@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class SpringConfig {

    /**
     * @return
     * @Scope 注解：调整作用域
     * 1.prototype：多实例的,IOC容器启动不会去调用方法创建对象放在容器中。
     * 每次获取的时候才会调用方法创建对象。
     * 2.singleton：单实例的（默认值）,IOC容器启动会调用方法创建对象放到IOC容器中。
     * 以后每次直接去IOC容器中获取。
     * 3.request：同一次请求创建一个实例
     * 4.session：同一个session创建一个实例
     * @Lazy 注解：懒加载
     * 1.单实例Bean：默认在容器启动的时候创建
     * 2.懒加载：容器启动不创建对象,第一次使用（获取）Bean创建对象。
     */
    //@Scope("prototype")
    @Lazy
    @Bean
    public Person person() {
        System.out.println("IOC容器创建Person...........");
        return new Person("张三", 20);
    }

    /**
     * @return
     * @Conditional 注解：按照一定的条件进行判断，满足条件在容器中注册Bean
     * <p>
     * 需求：
     * 1.如果系统是windows,给容器中注册@Bean("bill")
     * 2.如果系统是Linux系统,给容器中注册@Bean("linus")
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 63);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}
