package com.gymondo.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gymondo.api.mapper.VoucherMapper;
import com.gymondo.api.model.Voucher;

@Repository
public class VoucherRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Voucher findVoucherByCode(String voucherCode) {
		String sql = "SELECT * FROM voucher WHERE voucherCode = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{voucherCode}, new VoucherMapper());
	}

}
