package com.yueqin.core;

public enum HttpStatus {
	
	
	INNER_ERROR("内部服务器错误");
	
	//(INNER_ERROR,500),
	
	HttpStatus(String msg) {
		this.msgString = msg;
	}
	
	
	
	private String msgString;

	public String getMsgString() {
		return msgString;
	}

	public void setMsgString(String msgString) {
		this.msgString = msgString;
	}
	
	
	

}
