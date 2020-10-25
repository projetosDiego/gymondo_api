package com.gymondo.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gymondo.api.model.SubscriptionPlan;

public class PlanMapper implements RowMapper<SubscriptionPlan>{

	@Override
	public SubscriptionPlan mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new SubscriptionPlan(rs.getLong("planId"), 
						            rs.getString("planName"), 
						            rs.getLong("productId"), 
						            rs.getInt("duration"), 
						            rs.getLong("price"),
						            rs.getLong("tax"));
	}

}
