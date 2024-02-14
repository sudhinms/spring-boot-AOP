package com.spring.aop.aopDemo;

import com.spring.aop.aopDemo.service.BusinessService1;
import com.spring.aop.aopDemo.service.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoApplication implements CommandLineRunner{

	@Autowired
	private BusinessService1 service1;
	@Autowired
	private BusinessService2 service2;

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			logger.info(service1.businessMethod1());
		}catch (RuntimeException r){}
		logger.info(service2.businessMethod2());
	}
}
