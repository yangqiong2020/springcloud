package com.book.product.service;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.product.pojo.Product;
/**
 * Product服务接口
 * @author Administrator
 *
 */
@RequestMapping("/product")
public interface ProductService {
	
	//查询所有商品
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public List<Product> findAll();
}
