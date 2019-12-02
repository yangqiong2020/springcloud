package com.book.order.service;

import com.book.order.mapper.OrdersMapper;
import com.book.order.pojo.Orders;
import com.book.order.pojo.OrdersExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl {

	@Autowired
	private OrdersMapper orderMapper;
	
	/**
	 * 查询所有订单
	 */
	public List<Orders> findOrderAll(){
		OrdersExample example = new OrdersExample();
		return this.orderMapper.selectByExample(example);
	}


	/**
	 * 添加订单
	 */
	public Integer createOrder(Orders order){
		this.orderMapper.insert(order);
		return order.getId();
	}

	/**
	 * 根据ID查询订单
	 */
	public Orders findOrderById(Integer id){
		return this.orderMapper.selectByPrimaryKey(id);
	}

	/**
	 * 更新订单
	 */
	public void updateOrder(Orders order){
		this.orderMapper.updateByPrimaryKey(order);
	}
}
