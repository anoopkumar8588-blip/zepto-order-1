package com.zepto.order.controller;

import com.zepto.order.entity.OrderEntity;
import com.zepto.order.service.OrderService;
import com.zepto.order.request.OrderRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders/{id}/status")
	public ResponseEntity<String> getOrderStatus(
			@PathVariable Integer id) {

		OrderEntity order = orderService.getOrderById(id);
		return ResponseEntity.ok(order.getStatus());
	}

	@PutMapping("/orders/{id}/status")
	public ResponseEntity<String> updateOrderStatus(
			@PathVariable Integer id,
			@RequestBody OrderRequest orderRequest) {

		orderService.updateStatus(id, orderRequest.getStatus());
		return ResponseEntity.ok("Order Status Updated!!!");
	}
}
