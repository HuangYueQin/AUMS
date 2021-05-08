package com.yueqin.admin.configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CrosConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**")   //允许跨域的访问路径
		.allowedOrigins("*")         //允许跨域访问的源
		.allowedMethods("POST","GET","PUT","DELETE")  //允许的方法
		.maxAge(168000)            //预检时间间隔
		.allowedHeaders("*")       //允许头部设置
		.allowCredentials(true);   //是否发送cookie
	}
}
