package com.book.order.controller;

import com.book.order.pojo.Orders;
import com.book.order.service.OrderService;
import com.book.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController implements OrderService {

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@Override
	public List<Orders> findAll() {
		return this.orderServiceImpl.findOrderAll();
	}

	@Override
	public Integer addOrder(@RequestBody Orders order) {
		return this.orderServiceImpl.createOrder(order);
	}

	@Override
	public Orders findOrderById(Integer orderid) {
		return this.orderServiceImpl.findOrderById(orderid);
	}

	@Override
	public void updateOrder(@RequestBody Orders order) {
		this.orderServiceImpl.updateOrder(order);
	}
}
