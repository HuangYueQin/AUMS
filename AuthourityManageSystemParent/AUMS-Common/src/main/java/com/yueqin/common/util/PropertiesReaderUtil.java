package com.yueqin.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderUtil {
	
	public static Properties properties = new Properties();
	
	public static Properties loadProperties(String filename) {

		InputStream inputStream = null;
		try {
			 inputStream = PropertiesReaderUtil.class.getClassLoader()
	                  .getResourceAsStream(filename);
			if(inputStream == null) {
				throw new FileNotFoundException("文件没有找到");
			}
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(properties);
		return properties;
	}
	
	public static int getLength(Properties properties,String name) {
		
		int sum = 0;
		for (int i = 1; i <= properties.size(); i++) {
			
			boolean ispersent = properties.containsKey(name +i);
			if(ispersent) {
				sum ++;
			}
		}
		return sum;
	}
}
