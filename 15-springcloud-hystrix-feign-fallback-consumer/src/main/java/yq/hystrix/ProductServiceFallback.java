package yq.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import yq.pojo.Product;
import yq.service.ProductConsumerService;

@Component
public class ProductServiceFallback implements ProductConsumerService {

	//能够返回托底数据的fallback方法
	@Override
	public List<Product> findAll() {
		List<Product> list = new ArrayList<>();
		list.add(new Product(-1, "我是托底数据"));
		return list;
	}

}
