package yq.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import yq.pojo.Product;

@Service
public class ProductService {

	@Autowired
	private LoadBalancerClient loadBalancerClient;// ribbon负载均衡器

	@HystrixCommand(fallbackMethod = "fallback",
			commandProperties = {
			  //默认20个;10s内请求数大于20个时就启动熔断器，当请求符合熔断条件时将触发getFallback()。
		      @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, 

value="10000"),
		      //请求错误率大于50%时就熔断，然后for循环发起请求，当请求符合熔断条件时将触发getFallback()。
		      @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, 

value="50"),
		      //默认5秒;熔断多少秒后去尝试请求
		      @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, 

value="5000"),
		    })
	public List<Product> getUsers(int flag) {
		
		System.out.println(flag);
		if(flag == 1){
			throw new RuntimeException();
		}
		// 选择调用的服务的名称
		// ServiceInstance 封装了服务的基本信息，如 IP，端口
		ServiceInstance si = this.loadBalancerClient.choose("feign-provider");
		// 拼接访问服务的URL
		StringBuffer sb = new StringBuffer();
		// http://localhost:9001/product/findAll
		sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/product/findAll");
		System.out.println(sb.toString());
		// springMVC RestTemplate
		RestTemplate rt = new RestTemplate();

		ParameterizedTypeReference<List<Product>> type = new ParameterizedTypeReference<List<Product>>() {
		};

		// ResponseEntity:封装了返回值信息
		ResponseEntity<List<Product>> response = rt.exchange(sb.toString(), HttpMethod.GET, null, type);
		List<Product> list = response.getBody();
		return list;
	}
	
	//返回托底数据的方法
	public List<Product> fallback(int flag){
		List<Product> list = new ArrayList<>();
		list.add(new Product(-1, "我是托底数据"));
		return list;
	}
}
