package com.book.order.service;

import com.book.order.pojo.Orders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Order服务接口
 * @author Administrator
 *
 */
@RequestMapping("/order")
public interface OrderService {
	//查询所有订单
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public List<Orders> findAll();

	//添加订单
	@RequestMapping(value="/create",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Integer addOrder(@RequestBody Orders order);

	//根据订单ID查询订单
	@RequestMapping(value="/findOrderById",method=RequestMethod.GET)
	public Orders findOrderById(@RequestParam("orderid") Integer orderid);

	//更新订单
	@RequestMapping(value="/updateOrder",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateOrder(@RequestBody Orders order);
}
