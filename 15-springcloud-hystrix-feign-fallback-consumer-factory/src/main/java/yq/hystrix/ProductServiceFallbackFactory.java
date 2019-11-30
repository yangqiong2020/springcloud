package yq.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import feign.hystrix.FallbackFactory;
import yq.pojo.Product;
import yq.service.ProductConsumerService;

@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductConsumerService> {

	Logger logger = LoggerFactory.getLogger(ProductServiceFallbackFactory.class);

	@Override
	public ProductConsumerService create(final Throwable arg0) {
		
		return new ProductConsumerService() {
			
			//能够返回托底数据的fallback方法
			@Override
			public List<Product> findAll() {
				logger.warn("Fallback Exception: ",arg0);
				List<Product> list = new ArrayList<>();
				list.add(new Product(-1, "我是托底数据"));
				return list;
			}
		};
	}

}
