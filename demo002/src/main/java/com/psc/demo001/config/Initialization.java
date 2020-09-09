package com.psc.demo001.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Initialization implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.debug("Initialization... ... START");
		for (int i = 0; i < args.length; i++) {
			log.debug(args[i]);
		}
		log.debug("Initialization... ... END");
	}

}
