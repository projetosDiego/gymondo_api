package com.gymondo.api.model;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserApi {

	@Id
	@GeneratedValue
	private Long   userId;
	private String userName;
	private String userCode;
	private Long   subscriptionPlanId;
	private String SubscriptionStatus;
	private Timestamp dataIni;
	private Timestamp dataFin;
	
	public UserApi() {
		super();
	}

	public UserApi(Long userId, String userName, String userCode, Long subscriptionPlanId, String subscriptionStatus,
			Timestamp dataIni, Timestamp dataFin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userCode = userCode;
		this.subscriptionPlanId = subscriptionPlanId;
		this.SubscriptionStatus = subscriptionStatus;
		this.dataIni = dataIni;
		this.dataIni = dataFin;
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
	public Timestamp getDataIni() {
		return dataIni;
	}
	public void setDataIni(Timestamp dataIni) {
		this.dataIni = dataIni;
	}
	public Timestamp getDataFin() {
		return dataFin;
	}
	public void setDataFin(Timestamp dataFin) {
		this.dataFin = dataFin;
	}
}
