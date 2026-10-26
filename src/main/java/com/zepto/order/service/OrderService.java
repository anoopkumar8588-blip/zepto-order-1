
package com.zepto.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.order.entity.OrderEntity;
import com.zepto.order.repository.OrderRepository;
import com.zepto.order.exception.OrderNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public OrderEntity getOrderById(Integer id) {
		return orderRepository.findById(id)
				.orElseThrow(() ->
						new OrderNotFoundException(
								"Order Not Found - " + id));
	}

	public OrderEntity updateStatus(Integer id, String status) {
		OrderEntity entity = getOrderById(id);
		entity.setStatus(status);
		return orderRepository.save(entity);
	}
}
