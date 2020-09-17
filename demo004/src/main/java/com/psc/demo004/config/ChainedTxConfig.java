package com.psc.demo004.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Component
public class ChainedTxConfig {
 
    @Primary
	@Bean
    public PlatformTransactionManager transactionManager(
    		PlatformTransactionManager txManager1 ,
    		PlatformTransactionManager txManager2 ,
    		PlatformTransactionManager txManager3 ) {
    	
    	log.info("=======================================================");
    	log.info(txManager1.toString());
    	log.info(txManager2.toString());
    	log.info(txManager3.toString());
    	log.info("=======================================================");
    	
        return new ChainedTransactionManager(txManager1, txManager2, txManager3);
    }
}

