package com.example.multipledatasourcedemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author 91324
 */
@Configuration
//@MapperScan(basePackages = "com.example.multiple.datasource.mapper.db2", sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DataSourceConfig2 {
 
    @Bean("db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource getDb1DataSource(){
        return DataSourceBuilder.create().build();
    }


    // jdbc
    @Bean("db2JdbcTemplate")
    public JdbcTemplate sqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    // 配置事务管理器
    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager db1TransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("db2SqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/db2/*.xml"));
        return bean.getObject();
    }
 
    @Bean("db2SqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}