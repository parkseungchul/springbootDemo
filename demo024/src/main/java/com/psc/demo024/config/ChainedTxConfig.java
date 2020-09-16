package com.psc.demo024.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ChainedTxConfig {

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier("txManager1") PlatformTransactionManager txManager1, @Qualifier("txManager2") PlatformTransactionManager txManager2) {
        
    	log.info("===============================");
    	log.info(txManager1.toString());
    	log.info(txManager2.toString());
    	log.info("===============================");
    	return new ChainedTransactionManager(txManager1, txManager2);
    }
}
