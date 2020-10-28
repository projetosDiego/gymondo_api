package com.gymondo.api.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gymondo.api.model.UserSubscription;
import com.gymondo.api.repository.PurchaseRepository;

@Component @EnableScheduling
public class Timer {
	
	private final long SECOND = 1000; 
    private final long MINUTE = SECOND * 60; 
    private final long HOUR   = MINUTE * 60;
    private final long DAY    = HOUR * 60;
    public static final String ACTIVE = "active";
    
    @Autowired
	public PurchaseRepository purchaseRepository;
    
    @Scheduled(fixedDelay = MINUTE) 
    public void vrifyTrialPeriodEnd() { 
        List<UserSubscription> list = purchaseRepository.findAll();
        if(!list.isEmpty()) {
        	LocalDate localDate = LocalDate.now();
            for (UserSubscription userSubscription : list) {
//    			if(localDate.isEqual(userSubscription.getDateIni().toLocalDateTime().toLocalDate())) {
    			if(userSubscription.getDateIni().toLocalDateTime().toLocalDate().isEqual(userSubscription.getDateIni().toLocalDateTime().toLocalDate())) {	
    				userSubscription.setSubscriptionStatus(ACTIVE);
    				purchaseRepository.update(userSubscription);
    			}
    		}
        }
    }

}
