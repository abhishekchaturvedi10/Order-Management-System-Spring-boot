package com.egen.service;

import java.util.Optional;

import com.egen.entity.Customer;
import com.egen.vo.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.entity.Order;
import com.egen.repository.OrderRepository;
import com.egen.vo.OrderRequest;
import com.egen.vo.OrderResponse;

@Service
public class OrderServiceImpl implements OrderService{
	
	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderRepository orderRepo;


	@Override
	public OrderResponse findByOrderId(Long id){
		log.info("Finding order by Id: {}",id);
		Optional<Order> orderResult = orderRepo.findById(id);
		OrderResponse response = new OrderResponse();
		if (orderResult.isPresent()) {
			Order ordResult = orderResult.get();
			response.setCustomerId(ordResult.getCustomerId());
			response.setOrderId(ordResult.getOrderId());
			response.setTotal(ordResult.getTotal());
			response.setDiscount(ordResult.getDiscount());
		}else {
			log.error("Order is empty.");
            return null;
		}
		return response;
	}

	@Override
	public Order orderInsert(OrderRequest req){
			log.info("Inserting Order : {}", req.toString());
			Long total = req.getTotal();
			int discount = req.getDiscount();
			Long customerId = req.getCustomerId();
			Order orderObj = new Order(total, discount, customerId);
			orderRepo.save(orderObj);
			return orderObj;
	}
}