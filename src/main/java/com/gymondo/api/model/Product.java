package com.gymondo.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Product {
	
	@Id
	@GeneratedValue
	private Long   productId;
	private String productName;
	
	public Product() {
		super();
	}
	
	public Product(Long productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
