package com.example.multipledatasourcedemo.config;

import java.lang.annotation.*;

/**
 * 多数据源事务注解
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MultiTransactional {
 
    /**
     * 事务管理器数组
     */
    String[] transactionManagers();
}