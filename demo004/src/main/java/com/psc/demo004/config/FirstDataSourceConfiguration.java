package com.psc.demo004.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(value = "com.psc.demo004.mapper.first", sqlSessionFactoryRef = "firstSqlSessionFactory")
public class FirstDataSourceConfiguration {
     @Primary    
     @Bean(name = "firstDataSource")
     @ConfigurationProperties(prefix = "spring.first.datasource")
     public DataSource firstDataSource() {
         return DataSourceBuilder.create().build();
     }

     @Primary
     @Bean(name = "firstSqlSessionFactory")
     public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource firstDataSource,
                                 ApplicationContext applicationContext) throws Exception {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(firstDataSource);
            sqlSessionFactoryBean.setTypeAliasesPackage("com.psc.demo004.model");
            sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/first/**.xml"));
            return sqlSessionFactoryBean.getObject();
     }

     @Primary
     @Bean(name = "firstSessionTemplate")
     public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory firstSqlSessionFactory) {
         return new SqlSessionTemplate(firstSqlSessionFactory);
     }
}