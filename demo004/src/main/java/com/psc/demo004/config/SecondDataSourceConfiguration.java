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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(value = "com.psc.demo004.mapper.second", sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDataSourceConfiguration {
    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix="spring.second.datasource")
    public DataSource SecondDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "dataSource2")
    public DataSource dataSource2() {
        return new LazyConnectionDataSourceProxy(SecondDataSource());
    }
    

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource2,
                                                          ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource2);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.psc.demo004.model");
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/second/**.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "secondSessionTemplate")
    public SqlSessionTemplate secondSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory secondSqlSessionFactory) {
        return new SqlSessionTemplate(secondSqlSessionFactory);
    }
    

    
    @Bean
    public PlatformTransactionManager txManager2(DataSource dataSource2) {
        return new DataSourceTransactionManager(dataSource2);
    }
}