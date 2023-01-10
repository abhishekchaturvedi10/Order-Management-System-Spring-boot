package com.egen.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "phone")
    String phone;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private List<Order> orders = new ArrayList<>();

    protected Customer() {}

    public Customer(String name, String phone, List<Order> orders) {
        this.name = name;
        this.phone = phone;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders=orders;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", orders=" + orders + "]";
    }
}
