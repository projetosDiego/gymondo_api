package com.gymondo.api.service;

public interface IPurchaseService {

	String buyPlan(Long userId, Long productId);
	String puseSubscription(Long userId);
	String unpouseSubscription(Long userId);
	String cancelSubscription(Long userId);

}
