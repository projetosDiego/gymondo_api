package com.gymondo.api.service;

import com.gymondo.api.model.UserSubscription;

public interface IPurchaseService {

	String buyPlan(Long userId, Long productId, String voucherCode);
	String pauseSubscription(Long userId);
	String unpouseSubscription(Long userId);
	String cancelSubscription(Long userId);
	UserSubscription userSubscriptionInfo(Long userId);

}
