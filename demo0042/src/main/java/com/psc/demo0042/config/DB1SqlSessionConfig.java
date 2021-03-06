package com.psc.demo0042.config;

import javax.persistence.EntityManagerFactory;
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
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@MapperScan(value = "com.psc.demo0042.mapper.first", sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DB1SqlSessionConfig {
	
     @Bean(name = "orgDataSource1")
     @ConfigurationProperties(prefix = "spring.db1.datasource")
     public DataSource orgDataSource1() {
         return DataSourceBuilder.create().build();
     }
     

     @Bean(name = "dataSource1")
     public DataSource dataSource1() {
         return new LazyConnectionDataSourceProxy(orgDataSource1());
     }


     @Bean(name = "db1SqlSessionFactory")
     public SqlSessionFactory db1SqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource1,
                                 ApplicationContext applicationContext) throws Exception {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource1);
            sqlSessionFactoryBean.setTypeAliasesPackage("com.psc.demo0042.model");
            sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/db1/**.xml"));
            return sqlSessionFactoryBean.getObject();
     }

     @Primary
     @Bean(name = "db1SessionTemplate")
     public SqlSessionTemplate db1SessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory db1SqlSessionFactory) {
         return new SqlSessionTemplate(db1SqlSessionFactory);
     }
     
     @Bean(name = "entityManagerFactory1")
     public EntityManagerFactory entityManagerFactory1() {
         LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
         entityManagerFactoryBean.setDataSource(this.dataSource1());
         //entityManagerFactoryBean.setPersistenceUnitName("demo024");
         entityManagerFactoryBean.setPersistenceXmlLocation("classpath:/mapper/persistence1.xml");
         entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
         entityManagerFactoryBean.afterPropertiesSet();
         return entityManagerFactoryBean.getObject();
     }
      
     @Bean
     public JpaTransactionManager txManager1(EntityManagerFactory entityManagerFactory1) {
         return new JpaTransactionManager(entityManagerFactory1);
     }
      
    /** 
    @Bean
    public PlatformTransactionManager txManager1(DataSource dataSource1) {
        return new DataSourceTransactionManager(dataSource1);
    }
    **/
    
}