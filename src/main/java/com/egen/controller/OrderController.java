package com.egen.controller;

import com.egen.service.CustomerService;
import com.egen.vo.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.egen.entity.Order;
import com.egen.service.OrderService;
import com.egen.vo.OrderRequest;
import com.egen.vo.OrderResponse;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private CustomerService customerService;


	@RequestMapping("/hello")
	@ResponseBody
	public String helloWorld() {
		return "Welcome to order management system!";
	}

	@PostMapping("/create")
	public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest req){
		CustomerResponse customerResponse = customerService.findById(req.getCustomerId());
		int numOfOrdersPlaced = customerResponse.getOrders().size();
		if(numOfOrdersPlaced<=9) {
			req.setDiscount(0);
		}
		else if(numOfOrdersPlaced>9 && numOfOrdersPlaced<=19) {
			req.setDiscount(10);
		}
		else {
			req.setDiscount(20);
		}
		if(numOfOrdersPlaced == 9) {
			// Send Email on approaching gold
			System.out.println("Congratulations! You are just 1 order away from becoming a gold member.");
		}
		if(numOfOrdersPlaced == 19) {
			// Send Email on approaching platinum
			System.out.println("Congratulations! You are just 1 order away from becoming a platinum member.");
		}
		Order order = orderService.orderInsert(req);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id){
		OrderResponse result = orderService.findByOrderId(id);
		return new ResponseEntity<OrderResponse>(result,HttpStatus.OK);
	}
}
