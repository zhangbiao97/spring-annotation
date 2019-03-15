package com.spring.config;

import com.spring.entity.Car;
import com.spring.entity.Cat;
import org.springframework.context.annotation.*;

/**
 * bean的生命周期：
 *      bean创建 -> 初始化 -> 销毁的过程
 *
 * 容器管理bean的生命周期：
 *      我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化
 *      和销毁方法
 *
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 *
 * BeanPostProcessor.postProcessorBeforeInitialization
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 * BeanPostProcessor.postProcessorAfterInitialization
 * 销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法
 *
 *  BeanPostProcessor的原理：
 *      1.遍历得到容器所有的BeanPostProcessor，挨个执行beforeInitialization
 *      一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorBeforeInitialization
 *
 *      2.执行流程:
 *              1.populateBean(beanName,mbd,instanceWrapper);给Bean进行属性赋值
 *              initializeBean
 *              {
 *                  applyBeanPostProcessorBeforeInitialization(wrappedBean,beanName);
 *                  invokeInitMethods(beanName,wrappedBean,mbd);执行自定义初始化
 *                  applyBeanPostProcessorAfterInitialization(wrappedBean,beanName);
 *              }
 *
 *  1) 指定初始化和销毁方法：
 *         通过@Bean指定init-method和destory-method;
 *  2) 通过让Bean实现InitializingBean（定义初始化逻辑）
 *          disposableBean(定义销毁逻辑);
 *  3) 可以使用JSR250
 *      @PostConstruct：在bean创建完成并且属性赋值完成，来执行初始化方法
 *      @PreDestory：在容器销毁bean之前通知我们进行清理工作
 *  4) BeanPostProcessor【interface】:bean的后置处理器
 *      postProcessorBeforeInitialization：在初始化之前工作
 *      postProcessorAfterInitialization：在初始化之后工作
 *
 *
 */
@PropertySource("classpath:db.properties")
@ComponentScan(value={"com.spring.entity"})
@Configuration
public class LifeCycleConfig {

    //@Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }

}
