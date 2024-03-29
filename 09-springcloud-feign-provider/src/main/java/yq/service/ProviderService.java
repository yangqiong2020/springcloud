package yq.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yq.pojo.Product;
import yq.service.ProductService;

/**
 * Product-Provider服务
 * @author Administrator
 *
 */
@RestController
public class ProviderService implements ProductService {

	@Override
	public List<Product> findAll() {
//		try { //测试请求超时
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("来了老弟"+Thread.currentThread().getName());
		List<Product> list = new ArrayList<>();
		 list.add(new Product(1, "电视"));
		 list.add(new Product(2, "电脑"));
		 list.add(new Product(3, "冰箱"));
		 list.add(new Product(4, "手电筒"));
		return list;
	}

	@Override
	public Product getProductById(Integer id) {
		return new Product(id, "SpringCloud");
	}

	@Override
	public Product addProduct(Integer id, String name) {
		return new Product(id, name);
	}

	@Override
	public Product addProduct2(@RequestBody Product product) {
		return product;
	}

	@Override
	public Product addProduct3(@RequestBody Product product) {
		return product;
	}
}
