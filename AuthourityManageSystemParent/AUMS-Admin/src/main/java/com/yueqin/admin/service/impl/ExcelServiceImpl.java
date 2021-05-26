package com.yueqin.admin.service.impl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.visitor.functions.Length;
import com.yueqin.admin.service.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService {

	@Override
	public File convertWookbookToFile(Workbook workbook,String excelName) {
		// TODO Auto-generated method stub
		File file = null;
		OutputStream outStream = null;
		try {
			file = File.createTempFile(excelName, ".xlsx");
			outStream = new FileOutputStream(file.getAbsoluteFile());
			workbook.write(outStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		
		return file;
	}

	@Override
	public void dowloadFile(File file, String excelName, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		BufferedInputStream buff = null;
		BufferedOutputStream buff1 = null;
		try {
			response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(excelName+".xlsx","utf-8"));
			inputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			buff = new BufferedInputStream(inputStream);
		    buff1 = new BufferedOutputStream(outputStream);
			byte[] bytes = new byte[1024];
			
			int length = 0;
		    while( (length = buff.read(bytes)) != -1) {
		    	buff1.write(bytes,0,length);
		    }
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(buff != null) {
				try {
					buff.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(buff1 != null) {
				try {
					buff1.flush();
					buff1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	

}
