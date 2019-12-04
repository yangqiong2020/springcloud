package com.book.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.product.mapper.ProductMapper;
import com.book.product.pojo.Product;
import com.book.product.pojo.ProductExample;

@Service
public class ProductServiceImpl {
	
	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * 查询所有商品
	 * @return
	 */
	public List<Product> findProductAll(){
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("==========================");
		ProductExample example = new ProductExample();
		List<Product> list = this.productMapper.selectByExampleWithBLOBs(example);
		return list;
	}
}
