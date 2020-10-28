package com.gymondo.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gymondo.api.mapper.PlanMapper;
import com.gymondo.api.mapper.UserSubscriptionMapper;
import com.gymondo.api.model.SubscriptionPlan;
import com.gymondo.api.model.UserSubscription;

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

	public void insert(UserSubscription userSubscription) {
		String sql = "INSERT INTO usersubscription (userId,"
				+ "                                 userName, "
				+ "                                 planId, "
				+ "                                 planName, "
				+ "                                 price, "
				+ "                                 tax, "
				+ "                                 dateIni, "
				+ "                                 dateFin, "
				+ "                                 duration, "
				+ "                                 subscriptionStatus, "
				+ "                                 pauseDate,"
				+ "                                 trialDateIni,"
				+ "                                 trialDateFin) "
				+ "   VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{userSubscription.getUserId(),
				                              userSubscription.getUserName(), 
											  userSubscription.getPlanId(), 
											  userSubscription.getPlanName(),  
											  userSubscription.getPrice(), 
											  userSubscription.getTax(), 
											  userSubscription.getDateIni(),
											  userSubscription.getDateFin(),
											  userSubscription.getDuration(),
											  userSubscription.getSubscriptionStatus(),
											  userSubscription.getPauseDate(),
											  userSubscription.getTrialDateIni(),
											  userSubscription.getTrialDateFin()});
	}

	public UserSubscription findByUserId(Long userId) {
		String sql = "SELECT * FROM usersubscription WHERE userId = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new UserSubscriptionMapper());
	}
	
	public void update(UserSubscription userSubscription) {
		String sql = "UPDATE usersubscription" + " SET dateIni = ?," 
				+ "                                    dateFin = ?,"
				+ "                                    duration = ?,"
				+ "                                    subscriptionStatus = ?,"
				+ "                                    pauseDate = ?"
				+ "  WHERE userId = ?";
		jdbcTemplate.update(sql, new Object[]{userSubscription.getDateIni(),
											  userSubscription.getDateFin(),
											  userSubscription.getDuration(),
											  userSubscription.getSubscriptionStatus(),
											  userSubscription.getPauseDate(),
											  userSubscription.getUserId()});
	}
	
	public List<UserSubscription> findAll() {
		String sql = "SELECT * FROM usersubscription";
		return jdbcTemplate.query(sql, new UserSubscriptionMapper());
	}

	public void delete(Long userSubscriptionId) {
		String sql = "DELETE FROM usersubscription WHERE userSubscriptionId = ?";
		jdbcTemplate.update(sql, new Object[]{userSubscriptionId});
	}
	
	

}
