package com.gymondo.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gymondo.api.model.Voucher;

public class VoucherMapper implements RowMapper<Voucher>{

	@Override
	public Voucher mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Voucher(rs.getLong("voucherId"),
				           rs.getString("voucherCode"),
				           rs.getLong("priceDescount"),
				           rs.getLong("percentDescount")
				);
	}

}
