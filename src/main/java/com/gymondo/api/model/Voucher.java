package com.gymondo.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Voucher {
	
	@Id
	@GeneratedValue
	private Long   voucherId;
	private String voucherCode;
	private Long   priceDescount;
	private Long   percentDescount;
	
	public Voucher() {
		super();
	}

	public Voucher(Long voucherId, String voucherCode, Long priceDescount, Long percentDescount) {
		super();
		this.voucherId = voucherId;
		this.voucherCode = voucherCode;
		this.priceDescount = priceDescount;
		this.percentDescount = percentDescount;
	}

	public Long getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(Long voucherId) {
		this.voucherId = voucherId;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public Long getPriceDescount() {
		return priceDescount;
	}
	public void setPriceDescount(Long priceDescount) {
		this.priceDescount = priceDescount;
	}
	public Long getPercentDescount() {
		return percentDescount;
	}
	public void setPercentDescount(Long percentDescount) {
		this.percentDescount = percentDescount;
	}
}
