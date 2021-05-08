package com.yueqin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.yueqin.mapper")
public class AumsApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(AumsApplication.class, args);
		
	}

}
