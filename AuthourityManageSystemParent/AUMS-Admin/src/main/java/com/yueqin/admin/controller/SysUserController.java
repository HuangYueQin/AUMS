package com.yueqin.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.yueqin.admin.entity.SysUser;
import com.yueqin.admin.service.SysUserService;
import com.yueqin.admin.service.impl.SysUserServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yueqin
 * @since 2021-04-30
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

	@Autowired
	private SysUserServiceImpl userService;
	
	@GetMapping("/findAllUser")
	public List<SysUser> findAll(){
		
		return userService.list();
	}
}

