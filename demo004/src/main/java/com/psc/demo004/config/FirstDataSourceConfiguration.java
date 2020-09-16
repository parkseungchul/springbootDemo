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
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value = "com.psc.demo004.mapper.first", sqlSessionFactoryRef = "firstSqlSessionFactory")
public class FirstDataSourceConfiguration {
     @Primary    
     @Bean(name = "firstDataSource")
     @ConfigurationProperties(prefix = "spring.first.datasource")
     public DataSource firstDataSource() {
         return DataSourceBuilder.create().build();
     }
     

     @Bean(name = "dataSource1")
     public DataSource dataSource1() {
         return new LazyConnectionDataSourceProxy(firstDataSource());
     }

     @Primary
     @Bean(name = "firstSqlSessionFactory")
     public SqlSessionFactory firstSqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource1,
                                 ApplicationContext applicationContext) throws Exception {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource1);
            sqlSessionFactoryBean.setTypeAliasesPackage("com.psc.demo004.model");
            sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/first/**.xml"));
            return sqlSessionFactoryBean.getObject();
     }

     @Primary
     @Bean(name = "firstSessionTemplate")
     public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory firstSqlSessionFactory) {
         return new SqlSessionTemplate(firstSqlSessionFactory);
     }
     
    @Bean
    public PlatformTransactionManager txManager1(DataSource dataSource1) {
        return new DataSourceTransactionManager(dataSource1);
    }
    
}