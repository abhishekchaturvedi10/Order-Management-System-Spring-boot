package com.egen.service;

import com.egen.entity.Customer;
import com.egen.vo.CustomerRequest;
import com.egen.vo.CustomerResponse;

public interface CustomerService {

    CustomerResponse findById(Long id);

    Customer customerInsert(CustomerRequest o);
}
