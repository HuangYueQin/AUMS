package com.yueqin.core.service;

import java.util.List;

import com.yueqin.core.page.PageRequest;
import com.yueqin.core.page.PageResult;

/**
 * 通用Curd接口
 * yueqin
 * 2021-05-08
 * **/
public interface CurdService <T> {
    
	/*单一保存*/
	public int save(T record);
	/*单一删除*/
	public int delete(T record);
	/*批量删除*/
	public int delete(List<T> records);
	/*单个查询*/
	public T findById(Long id);
	/*分页查询*/
	public PageResult findPage(PageRequest request);
}
