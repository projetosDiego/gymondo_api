package com.gymondo.api.model;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserApi {

	@Id
	@GeneratedValue
	private Long      userId;
	private String    userName;
	private String    userCode;
	private Long      subscriptionPlanId;
	private String    SubscriptionStatus;
	private Timestamp dateIni;
	private Timestamp dateFin;
	private Timestamp pauseDateIni;
	
	public UserApi() {
		super();
	}

	public UserApi(Long userId, String userName, String userCode, Long subscriptionPlanId, String subscriptionStatus,
			Timestamp dateIni, Timestamp dateFin, Timestamp pauseDateIni) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userCode = userCode;
		this.subscriptionPlanId = subscriptionPlanId;
		SubscriptionStatus = subscriptionStatus;
		this.dateIni = dateIni;
		this.dateFin = dateFin;
		this.pauseDateIni = pauseDateIni;
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
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public Long getSubscriptionPlanId() {
		return subscriptionPlanId;
	}
	public void setSubscriptionPlanId(Long subscriptionPlanId) {
		this.subscriptionPlanId = subscriptionPlanId;
	}
	public String getSubscriptionStatus() {
		return SubscriptionStatus;
	}
	public void setSubscriptionStatus(String subscriptionStatus) {
		SubscriptionStatus = subscriptionStatus;
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
	public Timestamp getPauseDateIni() {
		return pauseDateIni;
	}
	public void setPauseDateIni(Timestamp pauseDateIni) {
		this.pauseDateIni = pauseDateIni;
	}
}
