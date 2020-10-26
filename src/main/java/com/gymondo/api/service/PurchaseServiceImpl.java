package com.gymondo.api.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymondo.api.model.SubscriptionPlan;
import com.gymondo.api.model.UserApi;
import com.gymondo.api.repository.PurchaseRepository;
import com.gymondo.api.repository.UserRepository;

@Service
public class PurchaseServiceImpl implements IPurchaseService{
	
	public static final String ACTIVE                = "active";
	public static final String PAUSED                = "paused";
	public static final String CANCELED              = "canceled";
	public static final String SUBSCRIPTION_DONE     = "Your subscription is done!";
	public static final String SUBSCRIPTION_PAUSED   = "Your subscription is paused.";
	public static final String SUBSCRIPTION_UNPAUSED = "Your subscription is unpaused.";
	public static final String SUBSCRIPTION_CANCELED = "Your subscription is canceled.";
	
	@Autowired
	public PurchaseRepository purchaseRepository;
	
	@Autowired
	public UserRepository     UserRepository;

	@Override
	public String buyPlan(Long userId, Long productId) {
		UserApi          userBd = UserRepository.findUserById(userId);
		SubscriptionPlan planBd = purchaseRepository.findByProductId(productId);
		
		userBd.setSubscriptionPlanId(planBd.getPlanId());
		userBd.setSubscriptionStatus(ACTIVE);
		
		LocalDateTime ini = LocalDateTime.now();
		LocalDateTime fin = ini.plusMonths(3);
		
		userBd.setDateIni(Timestamp.valueOf(ini));
		userBd.setDateFin(Timestamp.valueOf(fin));
		
		UserRepository.save(userBd);
		return SUBSCRIPTION_DONE;
	}

	@Override
	public String pauseSubscription(Long userId) {
		UserApi userBd = UserRepository.findUserById(userId);
		userBd.setSubscriptionStatus(PAUSED);
		
		userBd.setPauseDateIni(Timestamp.valueOf(LocalDateTime.now()));
		
		UserRepository.save(userBd);
		return SUBSCRIPTION_PAUSED;
	}

	@Override
	public String unpouseSubscription(Long userId) {
		UserApi userBd = UserRepository.findUserById(userId);
		userBd.setSubscriptionStatus(ACTIVE);
		
		Long          daysBetween = ChronoUnit.DAYS.between(userBd.getPauseDateIni().toLocalDateTime(), LocalDateTime.now());
		LocalDateTime dateFinAux  = userBd.getDateFin().toLocalDateTime();
		
		userBd.setDateFin(Timestamp.valueOf(dateFinAux.plusDays(daysBetween)));
		UserRepository.save(userBd);
		return SUBSCRIPTION_UNPAUSED;
	}

	@Override
	public String cancelSubscription(Long userId) {
		UserApi userBd = UserRepository.findUserById(userId);
		userBd.setSubscriptionStatus(CANCELED);
		
		userBd.setDateIni(null);
		userBd.setDateFin(null);
		userBd.setPauseDateIni(null);
		
		UserRepository.save(userBd);
		return SUBSCRIPTION_CANCELED;
	}

}
