package com.gymondo.api.model;

import java.util.Date;

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
	private Date   ini;
	private Date   fin;
	
	public UserApi() {
		super();
	}
	
	public UserApi(Long userId, String userName, String userCode, Long subscriptionPlanId, String subscriptionStatus,
			Date ini, Date fin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userCode = userCode;
		this.subscriptionPlanId = subscriptionPlanId;
		SubscriptionStatus = subscriptionStatus;
		this.ini = ini;
		this.fin = fin;
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
	public Date getIni() {
		return ini;
	}
	public void setIni(Date ini) {
		this.ini = ini;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
}
