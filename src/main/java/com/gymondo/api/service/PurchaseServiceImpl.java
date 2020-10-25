package com.gymondo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymondo.api.model.SubscriptionPlan;
import com.gymondo.api.model.UserApi;
import com.gymondo.api.repository.PurchaseRepository;
import com.gymondo.api.repository.UserRepository;

@Service
public class PurchaseServiceImpl implements IPurchaseService{
	
	@Autowired
	public PurchaseRepository purchaseRepository;
	@Autowired
	public UserRepository     UserRepository;

	@Override
	public String buyPlan(Long userId, Long productId) {
		UserApi          userBd = UserRepository.findUserById(userId);
		SubscriptionPlan planBd = purchaseRepository.findByProductId(productId);
		userBd.setSubscriptionPlanId(planBd.getPlanId());
		userBd.setSubscriptionStatus("ACTIVE");
		UserRepository.save(userBd);
		return null;
	}

}
