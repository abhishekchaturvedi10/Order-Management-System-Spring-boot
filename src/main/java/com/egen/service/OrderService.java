package com.egen.service;

import com.egen.entity.Order;
import com.egen.vo.OrderRequest;
import com.egen.vo.OrderResponse;

public interface OrderService {
	
	OrderResponse findByOrderId(Long id);
	
	Order orderInsert(OrderRequest o);
}
