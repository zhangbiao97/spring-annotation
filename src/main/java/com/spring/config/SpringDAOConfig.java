package com.spring.config;

import com.spring.custom.MyTypeCustom;
import com.spring.entity.Person;
import com.spring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Configuration 注解 告诉Spring这个类为配置类    配置类 == 配置文件
 * @ComponetScan 注解
 *      1.value：指定扫描的包
 *      2.includeFilters = Filter[] ：指定扫描的时候只需扫描哪些组件
 *          注意：如果使用includeFilters必须制定useDefaultFilters=false
 *      3.excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除哪些组件
 * @Filter
 *      1.FilterType.ANNOTATION：按照注解
 *      2.FilterType.ASSIGNABLE_TYPE：按照给定的类型
 *      3.FilterType.ASPECTJ：使用AspectJ表达式
 *      4.FilterType.REGEX：使用正则表达式
 *      5.FilterType.CUSTOM：使用自定义规则
 */
@Configuration
@ComponentScan(value = {"com.spring.controller","com.spring.dao","com.spring.service"},includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = UserService.class),
          @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeCustom.class)
},useDefaultFilters = false)
public class SpringDAOConfig {

    /**
     * @Bean 注解：给容器注册一个Bean,类型为返回值的类型,id默认用方法名作为id
     * @return
     */
    @Bean
    public Person person(){
        return new Person("张三",18);
    }

}
