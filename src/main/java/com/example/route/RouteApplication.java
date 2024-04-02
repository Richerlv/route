package com.example.route;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.route.mapper")
@SpringBootApplication
public class RouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouteApplication.class, args);
	}

}
