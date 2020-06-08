package com.dock.lwservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootConfiguration
@ServletComponentScan(basePackages = "com.dock.common.filter")
@MapperScan("com.dock.lwservice.code.mapper")
@ComponentScan(basePackages = {"com.dock"})
@SpringBootApplication
public class LwServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LwServiceApplication.class, args);
	}

}
