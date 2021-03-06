package com.psc.demo0042.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ChainedTxConfig {

    @Primary
	@Bean
    public PlatformTransactionManager transactionManager(
    		PlatformTransactionManager txManager1 ,
    		PlatformTransactionManager txManager2 ,
    		PlatformTransactionManager txManager3 ,
    		PlatformTransactionManager txManager4
    		) {
    	
    	log.info("=======================================================");
    	log.info(txManager1.toString());
    	log.info(txManager2.toString());
    	log.info(txManager3.toString());
    	log.info(txManager4.toString());
    	log.info("=======================================================");
    	
        return new ChainedTransactionManager(txManager1, txManager2, txManager3, txManager4);
    }
}
