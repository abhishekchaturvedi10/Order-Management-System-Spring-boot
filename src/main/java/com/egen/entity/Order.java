package com.egen.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderId")
	private Long orderId;

	@Column(name = "total")
	private Long total;

	@Column(name = "discount")
	private int discount;
	
	@Column(name = "customerId")
	private Long customerId;


	protected Order() {}

	public Order(Long total, int discount, Long customerId) {
		super();
		this.total = total;
		this.discount = discount;
		this.customerId = customerId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Order [id=" + orderId + ", total=" + total + ", discount=" + discount + ", customer id=" + customerId + "]";
	}
}
