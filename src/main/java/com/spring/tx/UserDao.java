package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql="insert into book(book_name,price) values(?,?)";
        String bookName = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,bookName,50);
    }


}
