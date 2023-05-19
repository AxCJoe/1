package com.softusing.joe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.softusing.joe.mapper")
public class JoeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoeApplication.class, args);
	}

}
