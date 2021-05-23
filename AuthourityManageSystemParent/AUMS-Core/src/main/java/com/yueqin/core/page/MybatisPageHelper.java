package com.yueqin.core.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yueqin.util.ReflectionUtil;

public class MybatisPageHelper {
	
	public static final String FINDPAGE = "findPage";

	public static PageResult findPage(PageRequest request,Object mapper,Object... args) {
		
		return findPage(request, mapper, FINDPAGE,args);
		
	}
	@SuppressWarnings({"unchecked","rawtypes"})
	public static PageResult findPage(PageRequest request,Object mapper,String queryName,Object...args){
		
		int pageNum = request.getPageNum();
		int pageSize = request.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		Object result = ReflectionUtil.invoke(mapper, queryName, args);
		return getPageResult(request,new PageInfo((List)result));	
	}
	
	public static PageResult getPageResult(PageRequest request,PageInfo<?> pageInfo) {
		 
		 PageResult result = new PageResult();
		 result.setPageNum(pageInfo.getPageNum());
		 result.setPageSize(pageInfo.getPageSize());
		 result.setTotalSize(pageInfo.getTotal());
		 result.setTotalPage(pageInfo.getPages());
		 
		 List list = pageInfo.getList();
		 int size = list.size();
		 result.setContent(list.subList(0, size));
		 System.out.println(list.subList(0, size));
		 return result;
	}
}
