package com.yueqin.admin.Converter;

import com.yueqin.admin.entity.SysUser;
import com.yueqin.common.entity.CommonUser;

public class UserConverter {

	public static CommonUser toCommonUser(SysUser user) {
		
		CommonUser commonUser = new CommonUser();
		
		commonUser.setId(user.getId());
		commonUser.setAvatar(user.getAvatar());
		commonUser.setCreateBy(user.getCreateBy());
		commonUser.setCreateTime(user.getCreateTime());
		commonUser.setDelFlag(user.getDelFlag());
		commonUser.setDeptId(user.getDeptId());
		commonUser.setEamil(user.getEamil());
		commonUser.setLastUpdateBy(user.getLastUpdateBy());
		commonUser.setLastUpdateTime(user.getLastUpdateTime());
		commonUser.setMobile(user.getMobile());
		commonUser.setName(user.getName());
		commonUser.setNickName(user.getNickName());
		commonUser.setPassword(user.getPassword());
		commonUser.setRoleId(user.getRoleId());
		commonUser.setSalt(user.getSalt());
		commonUser.setStatus(user.getStatus());
	
		return commonUser;
		
	}
}
