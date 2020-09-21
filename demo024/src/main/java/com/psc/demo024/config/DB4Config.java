package com.psc.demo024.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.google.common.collect.ImmutableMap;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.db4.datasource")
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory4",
        transactionManagerRef = "txManager4",
        basePackages = {"com.psc.demo024.db4.repository"})
public class DB4Config extends HikariConfig{

    @Bean
    public DataSource dataSource4() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(this));
    }

    @Bean
    public EntityManagerFactory entityManagerFactory4() {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(this.dataSource4());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaPropertyMap(ImmutableMap.of(        	
                "hibernate.hbm2ddl.auto", "none",
                "hibernate.dialect", "org.hibernate.dialect.OracleDialect",
                "hibernate.show_sql", "true"
        ));
        
        
        

     
        //factory.setPersistenceUnitName("db3");
        factory.setPackagesToScan("com.psc.demo024.db4.domain");
        factory.afterPropertiesSet();

        return factory.getObject();
    }
    


    @Bean
    public PlatformTransactionManager txManager4() {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory4());
        return tm;
    }

}
