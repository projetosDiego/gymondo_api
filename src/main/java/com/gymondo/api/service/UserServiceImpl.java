package com.gymondo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymondo.api.model.SubscriptionPlan;
import com.gymondo.api.model.UserApi;
import com.gymondo.api.model.UserSubscription;
import com.gymondo.api.repository.PurchaseRepository;
import com.gymondo.api.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	public UserRepository UserRepository;
	
	@Autowired
	public PurchaseRepository purchaseRepository;
	
	@Override
	public UserSubscription findUserInformations(Long userId) {
		UserApi          userBd = UserRepository.findUserById(userId);
		SubscriptionPlan planBd = purchaseRepository.findPlanById(userBd.getSubscriptionPlanId());
		return populateUserInfo(userBd, planBd);
	}

	private UserSubscription populateUserInfo(UserApi userBd, SubscriptionPlan planBd) {
		UserSubscription userInfo = new UserSubscription();
		userInfo.setUserId(userBd.getUserId());
		userInfo.setUserName(userBd.getUserName());
		userInfo.setUserCode(userBd.getUserCode());
		userInfo.setPlanName(planBd.getPlanName());
		userInfo.setDateIni(userBd.getDateIni());
		userInfo.setDateFin(userBd.getDateFin());
		userInfo.setPrice(planBd.getPrice());
		userInfo.setTax(planBd.getTax());
		userInfo.setDuration(planBd.getDuration());
		return userInfo;
	}

}
