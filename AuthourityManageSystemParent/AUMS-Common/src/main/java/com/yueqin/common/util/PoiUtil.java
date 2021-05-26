package com.yueqin.common.util;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yueqin.common.entity.CommonUser;

public class PoiUtil {

	public Workbook dowload(List<?> content,String filename) {
	
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		
		Row titleRow = sheet.createRow(0);
		
		
		Properties properties = PropertiesReaderUtil.loadProperties(filename);
		
		int length = PropertiesReaderUtil.getLength(properties, "title");
		titleRow = fillSheet(properties, "title", titleRow,length);
		
		for(int j = 1 ; j<= content.size(); j++) {
		   Row dataRow = sheet.createRow(j);
           CommonUser user = (CommonUser) content.get(j-1);
           length = PropertiesReaderUtil.getLength(properties, "englishTitle");
           dataRow = fillSheet(user, "englishTitle", dataRow,length,properties);
		}

		return workbook;
		
	}
	
	public Row fillSheet(Object object,String keyPrefix,Row row,int length,Properties ... prop) {
			
		for(int i = 1 ; i<= length ; i++) {
			String value = "";
			if( object instanceof Properties) {
				Properties properties = (Properties) object;
				value = properties.getProperty(keyPrefix + i);
			}else if(object instanceof CommonUser){
				CommonUser user = (CommonUser) object;
				String valuename = prop[0].getProperty(keyPrefix + i);
				String methodName = toCamelName(valuename).trim();
				Object obj = ReflectionUtil.invoke(user, methodName);
				value = String.valueOf(obj);
			}
			
			row.createCell(i).setCellValue(value);
		}
		return row;
	}
	
	public String toCamelName(String name) {
		
		String first = String.valueOf(name.charAt(0)).toUpperCase();
		
		return "get"+first+name.substring(1);
	}

}
