package com.yueqin.dbGenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class DBCodeGenerator {
	
	public static void main(String[] args) {
		
		AutoGenerator mpg = new AutoGenerator();
		
		//设置全局配置
		GlobalConfig gConfig = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		gConfig.setOutputDir(projectPath + "/src/main/java");
		gConfig.setAuthor("yueqin");
		gConfig.setOpen(false);
		gConfig.setFileOverride(false);
		gConfig.setServiceName("%sService"); //去除service I前缀
		gConfig.setIdType(IdType.AUTO);
		gConfig.setDateType(DateType.ONLY_DATE);
		gConfig.setSwagger2(true);
		
		mpg.setGlobalConfig(gConfig);
		
		//设置数据源
		DataSourceConfig dbConfig = new DataSourceConfig();
		dbConfig.setUrl("jdbc:mysql://localhost:3306/mango?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8");
		dbConfig.setDriverName("com.mysql.cj.jdbc.Driver");
		dbConfig.setUsername("root");
		dbConfig.setPassword("root");
		dbConfig.setDbType(DbType.MYSQL);
		mpg.setDataSource(dbConfig);
		
		//包的设置
		PackageConfig pConfig = new PackageConfig();
		pConfig.setParent("com.yueqin");
		pConfig.setEntity("entity");
		pConfig.setMapper("mapper");
		pConfig.setService("service");
		pConfig.setController("controller");
		mpg.setPackageInfo(pConfig);
		
		//策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setInclude("sys_config","sys_dept","sys_dict","sys_log","sys_login_log","sys_menu","sys_role","sys_role_dept","sys_role_menu","sys_user","sys_user_role");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true); //localhost:8080/hello_id_2
        mpg.setStrategy(strategy);
		
		mpg.execute();
	}

}
