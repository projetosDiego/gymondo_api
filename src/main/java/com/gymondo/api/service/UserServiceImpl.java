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
		UserSubscription userInfo = new UserSubscription();
		UserApi          userBd = UserRepository.findUserById(userId);
		SubscriptionPlan planBd = purchaseRepository.findPlanById(userBd.getSubscriptionPlanId());
		userInfo.setUserId(userBd.getUserId());
		userInfo.setUserName(userBd.getUserName());
		userInfo.setUserCode(userBd.getUserCode());
		userInfo.setPlanName(planBd.getPlanName());
		userInfo.setDateIni(userBd.getDataIni());
		userInfo.setDateFin(userBd.getDataFin());
		userInfo.setPrice(planBd.getPrice());
		userInfo.setTax(planBd.getTax());
		return userInfo;
	}

}
