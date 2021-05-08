package com.yueqin.configuration;

import javax.servlet.Servlet;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class DruidConfig{

	/*
	 * 注册servlet信息，配置监控视图
	 * */
	@Bean
	@ConditionalOnMissingBean
	public ServletRegistrationBean<Servlet> druidServlet(){
		
		ServletRegistrationBean<Servlet> register = new ServletRegistrationBean<Servlet>(
				new StatViewServlet(),"/druid/*");
		register.addInitParameter("allow", "127.0.0.1,192.168.0.108");
		register.addInitParameter("deny", "192.168.1.119");
		register.addInitParameter("loginUsername", "admin");
		register.addInitParameter("loginPassword", "admin");
		register.addInitParameter("resetEnable", "true");
		return register;
		
	}
}
