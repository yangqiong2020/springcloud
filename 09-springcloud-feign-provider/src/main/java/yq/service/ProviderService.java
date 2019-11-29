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
}
