package com.lzx.sboot.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceUtil {
    @Autowired
    private DataSource dataSource;
    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        try {
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setTypeAliasesPackage("com.lzx.sboot.entity");
            return sqlSessionFactoryBean.getObject();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
