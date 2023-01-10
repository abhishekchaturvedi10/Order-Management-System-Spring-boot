package com.egen.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {

	private Long total;
	private int discount;
	private Long customerId;

	
	public OrderRequest() {
	}
	
	public OrderRequest(Long total, int discount, Long customerId) {
		super();
		this.total = total;
		this.discount = discount;
		this.customerId = customerId;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
