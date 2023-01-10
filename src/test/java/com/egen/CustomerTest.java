package com.egen;

import com.egen.vo.CustomerRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.egen.service.CustomerService;

import java.util.ArrayList;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testCreateCustomer() {
        CustomerRequest customer = new CustomerRequest();
        customer.setName("TestingName");
        customer.setPhone("9828236323");
        customer.setOrders(new ArrayList<>());

        try {
            customerService.customerInsert(customer);
        }
        catch (Exception exc) {
            System.out.println("Test Failed");
        }
    }
}
