package com.example.multipledatasourcedemo.controller;

import com.example.multipledatasourcedemo.mapper.Db2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {


    @Autowired
    private Db2 db2;

    public void insertTEST() {
        String name = new String();
        db2.insert("lian");
        System.out.println("success");

    }
}
