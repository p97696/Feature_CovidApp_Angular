package com.apple.wipro.covid19.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class CovidTotal implements Serializable {
	
	private String error;
	private String message;
	private String statusCode;
	private CovidTotalEntity data;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CovidTotalEntity getData() {
		return data;
	}
	public void setData(CovidTotalEntity data) {
		this.data = data;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "CovidTotal [error=" + error + ", message=" + message + ", statusCode=" + statusCode + ", data=" + data
				+ "]";
	}
	
	
	

}
