package com.yueqin.admin.mapper;

import com.yueqin.admin.entity.SysUser;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yueqin
 * @since 2021-04-30
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
	
	public SysUser selectByPrimaryKey(long id);
	public List<SysUser> selectByName(String name);
	public List<SysUser> findPage();

}
