package com.psc.demo004.config;

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
@ConfigurationProperties(prefix = "spring.third.datasource")
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory3",
 //       transactionManagerRef = "txManager3",
        basePackages = {"com.psc.demo004.repository"})
public class ThirdDataSourceConfiguration extends HikariConfig{

    @Bean(name ="dataSource3")
    public DataSource dataSource3() {
        return new LazyConnectionDataSourceProxy(new HikariDataSource(this));
    }

    @Bean
    public EntityManagerFactory entityManagerFactory3() {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(this.dataSource3());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaPropertyMap(ImmutableMap.of(        	
                "hibernate.hbm2ddl.auto", "update",
                "hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect",
                "hibernate.show_sql", "true"
        ));
        
     
       
        factory.setPackagesToScan("com.psc.demo004.domain");
        //factory.setPersistenceUnitName("db3");
        factory.afterPropertiesSet();

        return factory.getObject();
    }
    
    @Bean(name="txManager3")
    public PlatformTransactionManager txManager3() {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory3());
        return tm;
    }
}
