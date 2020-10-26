package com.gymondo.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gymondo.api.mapper.PlanMapper;
import com.gymondo.api.model.SubscriptionPlan;

@Repository
public class PurchaseRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public SubscriptionPlan findByProductId(Long productId) {
		String sql = "SELECT * FROM subscriptionplan WHERE productId = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{productId}, new PlanMapper());
	}

	public SubscriptionPlan findPlanById(Long subscriptionPlanId) {
		String sql = "SELECT * FROM subscriptionplan WHERE planId = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{subscriptionPlanId}, new PlanMapper());
	}

}
