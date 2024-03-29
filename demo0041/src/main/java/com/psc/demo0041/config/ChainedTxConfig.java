package com.psc.demo0041.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ChainedTxConfig {
 
    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(PlatformTransactionManager transactionManager1, PlatformTransactionManager transactionManager2) {
        return new ChainedTransactionManager(transactionManager1, transactionManager2);
    }
}