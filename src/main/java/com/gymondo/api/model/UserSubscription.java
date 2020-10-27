package com.gymondo.api.model;

import java.sql.Timestamp;

public class UserSubscription {
	
	private Long      userSubscriptionId;
	private Long      userId;
	private String    userName;
	private Long      planId;
	private String    planName;
	private Long      price;
	private Long      tax;
	private Timestamp dateIni;
	private Timestamp dateFin;
	private Integer   duration;
	private String    subscriptionStatus;
	private Timestamp pauseDate;
	
	public UserSubscription() {
		super();
	}
	
	public UserSubscription(Long userSubscriptionId, Long userId, String userName, Long planId, String planName,
			Long price, Long tax, Timestamp dateIni, Timestamp dateFin, Integer duration, String subscriptionStatus,
			Timestamp pauseDate) {
		super();
		this.userSubscriptionId = userSubscriptionId;
		this.userId = userId;
		this.userName = userName;
		this.planId = planId;
		this.planName = planName;
		this.price = price;
		this.tax = tax;
		this.dateIni = dateIni;
		this.dateFin = dateFin;
		this.duration = duration;
		this.subscriptionStatus = subscriptionStatus;
		this.pauseDate = pauseDate;
	}

	public Long getUserSubscriptionId() {
		return userSubscriptionId;
	}
	public void setUserSubscriptionId(Long userSubscriptionId) {
		this.userSubscriptionId = userSubscriptionId;
	}
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
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public Timestamp getPauseDate() {
		return pauseDate;
	}
	public void setPauseDate(Timestamp pauseDate) {
		this.pauseDate = pauseDate;
	}
}
