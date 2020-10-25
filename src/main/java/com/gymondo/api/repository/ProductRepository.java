package com.gymondo.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gymondo.api.mapper.ProductMapper;
import com.gymondo.api.model.Product;

@Repository
public class ProductRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Product> findAll() {
		String sql = "SELECT * FROM product";
		return jdbcTemplate.query(sql, new ProductMapper());
	}

	public Product findById(Long id) {
		String sql = "SELECT * FROM product WHERE productId = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProductMapper());
	}
	
}
