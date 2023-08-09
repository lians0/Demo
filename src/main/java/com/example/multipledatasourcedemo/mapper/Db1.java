package com.example.multipledatasourcedemo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 91324
 */
@Component
public class Db1 {


    @Qualifier("db1JdbcTemplate")
    @Autowired
    private JdbcTemplate db1JdbcTemplate;
    
    
    public void insert(String name){
        db1JdbcTemplate.update("insert into user(name) values (?)",name);
    }
}
