package com.gymondo.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gymondo.api.model.UserApi;

public class UserMapper implements RowMapper<UserApi>{

	@Override
	public UserApi mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new UserApi(rs.getLong("userId"), 
				           rs.getString("userName"), 
				           rs.getString("userCode"), 
				           rs.getLong("subscriptionPlanId"), 
				           rs.getString("SubscriptionStatus"),
				           rs.getDate("ini"),
				           rs.getDate("fin")
				           );
	}

}
