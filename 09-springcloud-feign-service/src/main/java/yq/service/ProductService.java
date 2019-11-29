package yq.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import yq.pojo.Product;

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

	//根据商品ID查询商品
	@RequestMapping(value="/getProductById",method=RequestMethod.GET)
	public Product getProductById(@RequestParam("id") Integer id);

	//添加商品传递多个参数 方式一 ：GET方式
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public Product addProduct(@RequestParam("id") Integer id,@RequestParam("name") String name);

	//添加商品传递多个参数 方式二 ：POST方式
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Product addProduct2(@RequestBody Product product);
}
