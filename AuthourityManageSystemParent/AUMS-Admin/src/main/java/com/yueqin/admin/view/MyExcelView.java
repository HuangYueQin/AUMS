package com.yueqin.admin.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class MyExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String excelName = (String) model.get("excelName");
		Object object =  model.get("excelWorkbook");
		if(object instanceof Workbook) {
			Workbook tempWorkbook = (Workbook) object;
			//workbook.
			
		}
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(excelName+".xlsx","utf-8"));
		response.setCharacterEncoding("UTF-8");
	}
	
	

}
