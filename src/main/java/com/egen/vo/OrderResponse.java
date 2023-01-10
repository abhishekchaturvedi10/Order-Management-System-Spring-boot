package com.egen.vo;

import com.egen.entity.Customer;
import com.egen.service.CustomerService;

import java.util.List;

public class OrderResponse {
	
	private Long orderId;
	private Long total;

	private int discount;

	private Long customerId;

	private CustomerService customerService;

	public OrderResponse() {
		
	}
	
	public OrderResponse(Long orderId, Long total, int discount, Long customerId) {
		super();
		this.orderId = orderId;
		this.total = total;
		this.discount = discount;
		this.customerId = customerId;
	}

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) { this.total = total; }

	public int getDiscount() { return discount; }

	public void setDiscount(int discount) { this.discount = discount; }

	@Override
	public String toString() {
		return "OrderResponse [orderId= " + orderId + ", total= " + total + ", discount= " + discount + ", customerId= " + customerId + "]";
	}
}
