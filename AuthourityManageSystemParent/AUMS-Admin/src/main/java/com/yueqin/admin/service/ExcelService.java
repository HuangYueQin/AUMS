package com.yueqin.admin.service;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelService {

	public File convertWookbookToFile(Workbook workbook,String excelName);
	public void dowloadFile(File file,String excelName,HttpServletResponse response);
}
