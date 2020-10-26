package com.gymondo.api.model;

import java.sql.Timestamp;

public class UserSubscription {
	
	private Long      userId;
	private String    userName;
	private String    userCode;
	private String    planName;
	private Long      price;
	private Long      tax;
	private Timestamp dateIni;
	private Timestamp dateFin;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
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
	public Timestamp getDateIni() {
		return dateIni;
	}
	public void setDateIni(Timestamp dateIni) {
		this.dateIni = dateIni;
	}
	public Timestamp getDateFin() {
		return dateFin;
	}
	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}
}
