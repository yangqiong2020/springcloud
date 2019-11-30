package yq.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yq.hystrix.ProductServiceFallbackFactory;
import yq.pojo.Product;

@FeignClient(name="feign-provider",fallbackFactory=ProductServiceFallbackFactory.class)
public interface ProductConsumerService {
	    //查询所有商品
		@RequestMapping(value="/product/findAll",method=RequestMethod.GET)
		public List<Product> findAll();
}
