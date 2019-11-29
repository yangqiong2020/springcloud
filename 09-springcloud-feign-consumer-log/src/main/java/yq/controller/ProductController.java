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
	
	/**
	 * Consumer中根据商品id查询商品
	 */
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public Product getProduct(@RequestParam("id") Integer id){
		return this.consumerservice.getProductById(id);
	}
	
	/**
	 * 商品添加 传递多个参数。方式一：GET
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public Product addProduct(Product product){
		return this.consumerservice.addProduct(product.getId(), product.getName());
	}
	
	/**
	 * 商品添加 传递多个参数。方式二：POST
	 */
	@RequestMapping(value="/add2",method=RequestMethod.GET)
	public Product addProduct2(Product product){
		return this.consumerservice.addProduct2(product);
	}
	
}
