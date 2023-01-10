package com.egen.vo;

import com.egen.entity.Order;

import java.util.List;

public class CustomerResponse {

    private Long customerId;
    private String name;
    private String phone;
    private List<Order> orders;

    public CustomerResponse() {}

    public CustomerResponse(Long customerId, String name, String phone, List<Order> orders) {
        super();
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.orders = orders;
    }

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) { this.phone = phone; }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) { this.orders = orders; }

    @Override
    public String toString() {
        return "CustomerResponse [CustomerId= " + customerId + ", name= " + name + ", phoneNumber= " + phone + ", orders= " + orders + "]";
    }
}
