package yq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yq.pojo.Product;
import yq.service.ProductConsumerService;

/**
 * Product Consumer 服务
 * @author Administrator
 *
 */
@RestController
public class ProductController {

	@Autowired
	ProductConsumerService consumerservice;
	/**
	 * Consumer中的查询所有商品的方法
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Product> getAll(){
		return this.consumerservice.findAll();
	}
}
