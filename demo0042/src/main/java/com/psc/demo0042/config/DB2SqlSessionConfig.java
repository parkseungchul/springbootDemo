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
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@MapperScan(value = "com.psc.demo0042.mapper.second", sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DB2SqlSessionConfig {
    @Bean(name = "orgDataSource2")
    @ConfigurationProperties(prefix="spring.db2.datasource")
    public DataSource orgDataSource2() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "dataSource2")
    public DataSource dataSource2() {
        return new LazyConnectionDataSourceProxy(orgDataSource2());
    }
    

    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource2,
                                                          ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource2);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.psc.demo0042.model");
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/db2/**.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "db2SessionTemplate")
    public SqlSessionTemplate db2SessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory db2SqlSessionFactory) {
        return new SqlSessionTemplate(db2SqlSessionFactory);
    }
    
    @Bean(name = "entityManagerFactory2")
    public EntityManagerFactory entityManagerFactory2() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(this.dataSource2());
        //entityManagerFactoryBean.setPersistenceUnitName("demo024");
        entityManagerFactoryBean.setPersistenceXmlLocation("classpath:/mapper/persistence2.xml");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }
    
    
    @Bean
    public JpaTransactionManager txManager2(EntityManagerFactory entityManagerFactory2) {
        return new JpaTransactionManager(entityManagerFactory2);
    }
    
    /**
    @Bean
    public PlatformTransactionManager txManager2(DataSource dataSource2) {
        return new DataSourceTransactionManager(dataSource2);
    }
    **/
}