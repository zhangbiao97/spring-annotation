package com.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

/**
 * Profile：Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组建的功能；
 *
 * 开发环境、测试环境、生产环境
 * 数据库：A、B、C
 *
 * @Profile：指定组件在哪个环境的情况下才能被注册到IOC容器中，不指定，任何环境下都能注册这个组件；
 *      1、加了环境标识的bean，只有这个环境被激活的时候才能注册到IOC容器中，默认是default环境；
 *      2、写在配置雷上，只有是指定的环境的时候，整个配置雷里面的所有配置才能生效；
 *      3、没有标注环境标识的bean，在任何环境下都是加载的；
 *
 * @Profile 激活方式：
 *      1、使用命令行动态参数：在虚拟机参数位置加载 -> -Dspring.profiles.active=test
 *      2、代码的方式激活某种环境
 *          1)、创建一个applicationContext
 *              new AnnotationConfigApplicationContext();
 *              注意：使用的是无参构造！
 *          2)、设置需要激活的环境
 *              applicationContext.getEnvironment().setActiveProfiles();
 *          3)、注册配置类
 *              applicationContext.register();
 *          4)、启动刷新容器
 *              applicationContext.refresh();
 *
 *
 */
@Configuration
@PropertySource("classpath:db.properties")
public class SpringConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${jdbc.username}")
    private String username;

    private String url;

    public DruidDataSource dataSource(String pwd){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(pwd);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DruidDataSource druidDataSourceDev(@Value("${jdbc.password}") String pwd) {
        return dataSource(pwd);
    }

    @Profile("test")
    @Bean("testDataSource")
    public DruidDataSource druidDataSourceTest(@Value("${jdbc.password}") String pwd) {
        return dataSource(pwd);
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DruidDataSource druidDataSourceProd(@Value("${jdbc.password}") String pwd) {
        return dataSource(pwd);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String url = resolver.resolveStringValue("${jdbc.url}");
        this.url = url;
    }
}
