package com.book.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.book.product.pojo.Product;
import com.book.product.service.ProductService;
import com.book.product.service.ProductServiceImpl;

@RestController
public class ProductServiceController implements ProductService {

	@Autowired
	private ProductServiceImpl productServiceImple;
	
	@Override
	public List<Product> findAll() {
		return this.productServiceImple.findProductAll();
	}

}
