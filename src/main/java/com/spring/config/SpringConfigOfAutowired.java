package com.spring.config;

import com.spring.dao.UserDao;
import com.spring.entity.Boss;
import com.spring.entity.Car;
import org.springframework.context.annotation.*;

/**
 * 自动装配：
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值；
 *
 * 1、@Autowired：自动注入：
 *      1)、默认优先按照类型去容器中找对应的组件：applicationContext.getBean(userDao.class);找到赋值；
 *      2)、如果找到多个相同类型的组件，再降属性的名称作为组件的id去容器中查找，
 *              applicationContext.getBean("userDao");
 *      3)、@Qualifier("userDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名；
 *      4)、自动装配默认一定要降属性赋值好，没有就会报错；
 *          可以使用@Autowired(required = false);
 *      5)、@Primary：让Spring进行自动装配的时候，默认使用首选的bean，也可以继续使用@Qualifier
 *          指定需要装配的bean
 *
 * 2、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范注解]
 *      @Resource:
 *          可以和@Autowired一样实现自动装配功能，默认是按照组件名称进行装配的；
 *          不能支持@Primary功能，也不能支持@Autowired(required = false)
 *      @Inject：
 *          需要导入javax.inject的包，和@Autowired的功能一样，没有required功能
 *      注意：
 *          1、@Autowired：Spring定义的；
 *          2、@Resource，@Inject都是java规范定义的
 *
 * 3、@Autowired：构造器，参数，方法，属性；都是从容器中获取参数组件的值
 *      1)、标注再方法位置：@Bean+方法参数；参数从容器中获取，默认不写@Autowired效果是一样的，都能自动装配；
 *      2)、标注再构造器上：如果组件只有一个有参构造，这个有参构造的@Autowired可以省略，参数位置的组件还是
 *          可以从容器中获取
 *      3)、放在参数位置
 *
 * 4、自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory,xxx）
 *      自定义组件实现xxxAware；再创建对象的时候，会调用接口规定的方法注入相关组件；Aware
 *      把Spring底层一些组件注入到自定义的Bean中；
 *      xxxAware：功能使用xxxProcessor
 *          ApplicationContextAware -> ApplicationContextAwareProcessor；
 */
@Configuration
@ComponentScan({"com.spring.controller","com.spring.dao","com.spring.service"
    ,"com.spring.entity"})
@PropertySource("classpath:db.properties")
public class SpringConfigOfAutowired {

    @Primary
    @Bean("userDao2")
    public UserDao userDao(){
        return new UserDao("2");
    }

    @Bean
    public Boss boss(Car car){
        return new Boss(car);
    }

}
