package com.yueqin.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.yueqin.admin.mapper")
public class AumsAdminApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(AumsAdminApplication.class, args);
		
	}

}
