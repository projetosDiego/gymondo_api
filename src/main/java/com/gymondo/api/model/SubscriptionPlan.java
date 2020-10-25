package com.gymondo.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class SubscriptionPlan {

	@Id
	@GeneratedValue
	private Long    planId;
	private String  planName;
	private Long    productId;
	private Integer duration;
	private Long    price;
	private Long    tax;
	
	public SubscriptionPlan() {
		super();
	}
	
	public SubscriptionPlan(Long planId, String planName, Long productId, Integer duration, Long price, Long tax) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.productId = productId;
		this.duration = duration;
		this.price = price;
		this.tax = tax;
	}

	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getTax() {
		return tax;
	}
	public void setTax(Long tax) {
		this.tax = tax;
	}
}
