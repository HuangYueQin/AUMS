package com.yueqin.core.page;

import java.util.List;

/**
 * 分页结果
 * 2021-05-08
 * **/

public class PageResult {
	
	/*页码*/
	private int pageNum;
	/*每页大小*/
	private int pageSize;
	/*总大小*/
	private int totalSize;
	/*总页数*/
	private int totalPage;
	/*查询内容*/
	private List<?> content;
	
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
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<?> getContent() {
		return content;
	}
	public void setContent(List<?> content) {
		this.content = content;
	}
	
	

}
