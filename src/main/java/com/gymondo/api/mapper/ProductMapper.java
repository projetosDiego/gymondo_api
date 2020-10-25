package com.gymondo.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gymondo.api.model.Product;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Product(rs.getLong("productId"), rs.getString("productName"));
	}

}
