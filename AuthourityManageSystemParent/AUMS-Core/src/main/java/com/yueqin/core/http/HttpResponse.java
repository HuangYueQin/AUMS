package com.yueqin.core.http;

import org.apache.ibatis.ognl.ASTThisVarRef;
import org.springframework.boot.json.JacksonJsonParser;

import com.yueqin.core.HttpStatus;

public class HttpResponse {
	
	private int code = 200;
	private String msg;
	private Object data;
	
	
    public static HttpResponse ok() {
		
		HttpResponse response = new HttpResponse();
		return response;
	}
    
    public static HttpResponse ok(String msg) {
		
		HttpResponse response = new HttpResponse();
		response.setMsg(msg);
		return response;
	}
    
    public static HttpResponse ok(Object data) {
		
		HttpResponse response = new HttpResponse();
		response.setData(data);
		return response;
	}
    
    public static HttpResponse ok(String msg,Object data) {
		
		HttpResponse response = new HttpResponse();
		response.setData(data);
		response.setMsg(msg);
		return response;
	}

    public static HttpResponse errorResponse() {
		
		HttpResponse response = new HttpResponse();
		response.setMsg("未知错误，请联系管理员");
		response.setCode(500);
		return response;
	}

    public static HttpResponse errorResponse(int code) {
		
		HttpResponse response = new HttpResponse();
		response.setMsg(HttpStatus.INNER_ERROR.getMsgString());
		response.setCode(code);
		return response;
	}
    
    public static HttpResponse errorResponse(String msg) {
		
		HttpResponse response = new HttpResponse();
		response.setMsg(msg);
		response.setCode(500);
		return response;
	}

	public static HttpResponse errorResponse(int code,String msg) {
		
		HttpResponse response = new HttpResponse();
		response.setMsg(msg);
		response.setCode(code);
		return response;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
}
