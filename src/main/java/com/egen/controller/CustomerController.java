package com.egen.controller;

import com.egen.service.CustomerService;
import com.egen.vo.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.egen.entity.Customer;
import com.egen.vo.CustomerResponse;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/hellocustomer")
    @ResponseBody
    public String helloWorld() {
        return "Welcome to order management system!";
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> placeCustomer(@RequestBody CustomerRequest req){
        Customer customer = customerService.customerInsert(req);
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id){
        CustomerResponse result = customerService.findById(id);
        return new ResponseEntity<CustomerResponse>(result,HttpStatus.OK);
    }
}