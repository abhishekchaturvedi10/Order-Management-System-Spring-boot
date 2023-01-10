package com.egen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.egen.service.OrderService;
import com.egen.vo.OrderRequest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderTest {

	@Autowired
	private OrderService orderService;
	
	@Test
	public void testCreateOrder() {
		OrderRequest order = new OrderRequest();
		order.setTotal(Long.valueOf(532));
		order.setDiscount(10);
		order.setCustomerId(Long.valueOf(1));
		
		try {
			orderService.orderInsert(order);
		}
		catch (Exception exc) {
			System.out.println("Test Failed");
		}
	}
}
