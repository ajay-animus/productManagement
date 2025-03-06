package com.ecommerce.productservice.constant;

public enum ExceptionEnum {

	PRODUCT_NOT_FOUND("product not found.");
	
	private final String message;
	
	ExceptionEnum(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
