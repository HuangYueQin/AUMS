package com.yueqin.admin.controller;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yueqin.admin.entity.SysUser;
import com.yueqin.admin.service.ExcelService;
import com.yueqin.admin.service.impl.SysUserServiceImpl;
import com.yueqin.admin.view.MyExcelView;
import com.yueqin.core.http.HttpResponse;
import com.yueqin.core.page.PageRequest;

import net.bytebuddy.asm.Advice.Return;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yueqin
 * @since 2021-04-30
 */
@Controller
@RequestMapping("/sys-user")
public class SysUserController {

	@Autowired
	private SysUserServiceImpl userService;
	
	@Autowired
	private ExcelService excelService;
	
	private final String filename = "SysUserExcelHeader.properties";
	
	@GetMapping("/findAllUser")
	public @ResponseBody List<SysUser> findAll(){
		
		return userService.list();
	}
	
	@PostMapping("/findPage")
	public @ResponseBody HttpResponse findPage(@RequestBody PageRequest request) {
		
		return HttpResponse.ok(userService.findPage(request));
	}
	
	@PostMapping("/dowload")
	public @ResponseBody String dowload(@RequestBody PageRequest request,HttpServletResponse response) {
 
		String excelName = "SysUser";
		Workbook workbook = userService.dowload(request, filename);
		File file = excelService.convertWookbookToFile(workbook, excelName);
		excelService.dowloadFile(file,excelName,response);
		return "ok";
		
	}
}

