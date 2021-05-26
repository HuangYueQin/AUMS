package com.yueqin.admin.service.impl;

import com.yueqin.admin.Converter.UserConverter;
import com.yueqin.admin.entity.SysUser;
import com.yueqin.admin.mapper.SysUserMapper;
import com.yueqin.admin.service.SysUserService;
import com.yueqin.common.entity.CommonUser;
import com.yueqin.common.util.PoiUtil;
import com.yueqin.core.page.MybatisPageHelper;
import com.yueqin.core.page.PageRequest;
import com.yueqin.core.page.PageResult;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
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

	@Override
	public Workbook dowload(PageRequest request,String filename) {
		// TODO Auto-generated method stub
		PageResult result = MybatisPageHelper.findPage(request, userMapper);
		PoiUtil poiUtil = new PoiUtil();
		Workbook workbook = null;
		
		List<CommonUser> commonUsers = new ArrayList<CommonUser>();
		
		for (int i = 0; i < result.getContent().size(); i++) {
			
			 @SuppressWarnings("unchecked")
			 List<SysUser> list = (List<SysUser>) result.getContent();
			 SysUser user = list.get(i);
			 CommonUser commonUser = UserConverter.toCommonUser(user);
			 commonUsers.add(commonUser);
		}
		
		if(result.getContent() != null && commonUsers.size() > 0) {
			workbook = poiUtil.dowload(commonUsers,filename);
		}
		return workbook;
	}
	
}
