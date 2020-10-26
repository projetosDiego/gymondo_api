package com.gymondo.api.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
		
		LocalDateTime ini = LocalDateTime .now();
		LocalDateTime fin = ini.plusMonths(3);
		
		userBd.setDataIni(Timestamp.valueOf(ini));
		userBd.setDataFin(Timestamp.valueOf(fin));
		
		UserRepository.save(userBd);
		return null;
	}

	@Override
	public String puseSubscription(Long userId) {
		UserApi userBd = UserRepository.findUserById(userId);
//		userBd.setSubscriptionStatus("PAUSED");
		UserRepository.save(userBd);
		return null;
	}

	@Override
	public String unpouseSubscription(Long userId) {
		UserApi userBd = UserRepository.findUserById(userId);
//		userBd.setSubscriptionStatus("ACTIVE");
		UserRepository.save(userBd);
		return null;
	}

	@Override
	public String cancelSubscription(Long userId) {
		UserApi userBd = UserRepository.findUserById(userId);
		userBd.setSubscriptionStatus("CANCELED");
		userBd.setDataIni(null);
		userBd.setDataFin(null);
		UserRepository.save(userBd);
		return null;
	}

}
