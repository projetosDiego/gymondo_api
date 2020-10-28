package com.gymondo.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gymondo.api.model.UserSubscription;

public class UserSubscriptionMapper implements RowMapper<UserSubscription>{

	@Override
	public UserSubscription mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new UserSubscription(rs.getLong("userSubscriptionId"),
				                    rs.getLong("userId"),
				                    rs.getString("userName"),
				                    rs.getLong("planId"),
				                    rs.getString("planName"),
				                    rs.getLong("price"),
				                    rs.getLong("tax"),
				                    rs.getTimestamp("dateIni"),
				                    rs.getTimestamp("dateFin"),
				                    rs.getInt("duration"),
				                    rs.getString("subscriptionStatus"),
				                    rs.getTimestamp("pauseDate"),
				                    rs.getTimestamp("trialDateIni"),
				                    rs.getTimestamp("trialDateFin")
				);
	}

}
