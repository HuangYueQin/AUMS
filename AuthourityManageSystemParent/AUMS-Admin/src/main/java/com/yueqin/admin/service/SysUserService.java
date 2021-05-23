package com.yueqin.admin.service;

import com.yueqin.admin.entity.SysUser;
import com.yueqin.core.page.PageRequest;
import com.yueqin.core.page.PageResult;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yueqin
 * @since 2021-04-30
 */
@Service
public interface SysUserService extends IService<SysUser> {
	
	public PageResult findPage(PageRequest request);

}
