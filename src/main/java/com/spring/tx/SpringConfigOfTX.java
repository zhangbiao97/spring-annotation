package com.spring.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 声明式事务：
 *
 * 环境搭建：
 *      1、导入相关依赖
 *          数据源、数据库驱动、Spring-jdbc模块；
 *      2、配置数据源、JdbcTemplate（Spring提供的简化数据库操作的工具）操作数据；
 *      3、给方法上标注@Transactional表示当前方法是一个事务方法；
 *      4、@EnableTransactionManagement开启基于注解的事务管理功能；
 *      5、配置事务管理器来控制事务；
 *          @Bean
 *          public PlatformTransactionManager transactionManager(){}
 */
@EnableTransactionManagement
@ComponentScan("com.spring.tx")
@Configuration
public class SpringConfigOfTX {

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("zhangbiao");
        dataSource.setUrl("jdbc:mysql://123.56.9.64:3306/myschool");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }




}
