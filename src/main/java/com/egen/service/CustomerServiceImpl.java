package com.egen.service;

import java.util.List;
import java.util.Optional;

import com.egen.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.entity.Order;
import com.egen.repository.CustomerRepository;
import com.egen.vo.CustomerRequest;
import com.egen.vo.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService{

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public CustomerResponse findById(Long id){
        log.info("Finding customer by Id: {}",id);
        Optional<Customer> customerResult = customerRepo.findById(id);
        CustomerResponse response = new CustomerResponse();
        if (customerResult.isPresent()) {
            Customer custResult = customerResult.get();
            response.setCustomerId(custResult.getId());
            response.setName(custResult.getName());
            response.setPhone(custResult.getPhone());
            response.setOrders(custResult.getOrders());
        }else {
            log.error("Customer is empty.");
            return null;
        }
        return response;
    }

    @Override
    public Customer customerInsert(CustomerRequest req){
        log.info("Inserting Customer : {}", req.toString());
        String name = req.getName();
        String phone = req.getPhone();
        List<Order> orders = req.getOrders();
        Customer CustomerObj = new Customer(name, phone, orders);
        customerRepo.save(CustomerObj);
        return CustomerObj;
    }
}