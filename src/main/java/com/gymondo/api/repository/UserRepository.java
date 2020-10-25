package com.gymondo.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gymondo.api.mapper.UserMapper;
import com.gymondo.api.model.UserApi;

@Repository
public class UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public UserApi findUserById(Long userId) {
		String sql = "SELECT * FROM userapi WHERE userId = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new UserMapper());
	}

	public void save(UserApi userBd) {
		String sql = "UPDATE userapi" + " SET subscriptionPlanId = ?, SubscriptionStatus = ? " + " WHERE userId = ?";
		jdbcTemplate.update(sql, new Object[]{userBd.getSubscriptionPlanId(), userBd.getSubscriptionStatus(), userBd.getUserId()});
	}

}
