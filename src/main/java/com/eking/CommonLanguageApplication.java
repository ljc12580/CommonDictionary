package com.eking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eking.mapper")
public class CommonLanguageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonLanguageApplication.class, args);
	}
}
