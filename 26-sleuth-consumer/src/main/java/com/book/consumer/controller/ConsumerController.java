package com.book.consumer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.book.consumer.service.ConsumerProductService;
import com.book.product.pojo.Product;

/**
 * 创建订单
 * @author Administrator
 *
 */
@RestController
public class ConsumerController {

	@Autowired
	private ConsumerProductService productService;
	

	@RequestMapping(value="/find",method=RequestMethod.GET)
	public List<Product> createOrder(){
		List<Product> products = this.productService.findAll();
		System.out.println("-----------------------");
		return products;
	}
	
}
