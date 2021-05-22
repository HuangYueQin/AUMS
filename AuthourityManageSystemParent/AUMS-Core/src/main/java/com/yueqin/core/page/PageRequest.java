package com.yueqin.core.page;
/**
 * 分页请求
 * 2021-05-08
 * **/

import java.util.HashMap;
import java.util.Map;

public class PageRequest {
  
	/*默认当前页*/
	private int pageNum = 1;
	/*默认页大小*/
	private int pageSize = 10;
	/*查询参数*/
	private Map<String, Object> params = new HashMap<String, Object>();
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	
	
}
