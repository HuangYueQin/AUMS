package com.yueqin.admin.service.impl;

import com.yueqin.admin.entity.SysUser;
import com.yueqin.admin.mapper.SysUserMapper;
import com.yueqin.admin.service.SysUserService;
import com.yueqin.core.page.MybatisPageHelper;
import com.yueqin.core.page.PageRequest;
import com.yueqin.core.page.PageResult;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yueqin
 * @since 2021-04-30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	@Autowired
	private SysUserMapper userMapper;

	@Override
	public PageResult findPage(PageRequest request) {
		// TODO Auto-generated method stub
		return MybatisPageHelper.findPage(request,userMapper);
	}

	/*
	 * @Override public PageResult findPage(PageRequest request) { // TODO
	 * Auto-generated method stub return MybatisPageHelper.findPage(request,
	 * userMapper); }
	 */
	
}
