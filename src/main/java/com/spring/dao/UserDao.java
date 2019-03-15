package com.spring.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private String label = "1";

    public UserDao(){}

    public UserDao(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
