package com.rasoluti.infrastructure.error;

import java.util.Date;
import java.util.HashMap;

public class ApiError {

	private Long timestamp ;
	private Integer status;
	private String error;
	private String path;
	private HashMap<String, String> erros;
	
	public ApiError() {

	}

	public ApiError( Integer status, String error, String path) {
		this.timestamp = new Date().getTime();
		this.status = status;
		this.error = error;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HashMap<String, String> getErros() {
		return erros;
	}

	public void setErros(HashMap<String, String> erros) {
		this.erros = erros;
	}
	
	
	
	

}
