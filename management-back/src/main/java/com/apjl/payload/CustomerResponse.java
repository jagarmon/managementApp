package com.apjl.payload;

public class CustomerResponse {
	private String customerName;
	private String message;
	public CustomerResponse(String customerName, String message) {
		this.customerName = customerName;
		this.message = message;
	}
	
	public String getEntityName() {
		return customerName;
	}
	public void setEntityName(String customerName) {
		this.customerName = customerName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
