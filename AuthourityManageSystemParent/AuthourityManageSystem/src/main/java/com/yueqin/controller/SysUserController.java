package com.yueqin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.yueqin.entity.SysUser;
import com.yueqin.service.SysUserService;
import com.yueqin.service.impl.SysUserServiceImpl;

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

