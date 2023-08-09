package com.example.multipledatasourcedemo.mapper;

import com.example.multipledatasourcedemo.config.MultiTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 91324
 */
@Component
public class Db2 {


    @Qualifier("db2JdbcTemplate")
    @Autowired
    private JdbcTemplate db2JdbcTemplate;
    @Qualifier("db1JdbcTemplate")
    @Autowired
    private JdbcTemplate db1JdbcTemplate;


    // TODO clean: 2023-08-09T22:19:04.199909
    public void insertTEST() {
        String name = new String();
        insert("lian");
        System.out.println();
    }

    //    @Transactional(rollbackFor = Exception.class,transactionManager = "db2TransactionManager")
    @MultiTransactional(transactionManagers = {"db2TransactionManager"})
    public void insert(String name) {
        db2JdbcTemplate.update("insert into user(name) values (?)", name);
        db1JdbcTemplate.update("insert into user(name) values (?)", name);
        int i = 1 / 0;
    }
}
