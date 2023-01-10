package com.egen.vo;

import com.egen.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRequest {

    private String name;
    private String phone;
    private List<Order> orders;


    public CustomerRequest() {
    }

    public CustomerRequest(String name, String phone, List<Order> orders) {
        super();
        this.name = name;
        this.phone = phone;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
