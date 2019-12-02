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
import yq.pojo.Product;

@Service
public class ProductService {

	@Autowired
	private LoadBalancerClient loadBalancerClient;// ribbon负载均衡器

	@HystrixCommand(groupKey="dashboard-mq-consumer", commandKey = "getUsers",
		    threadPoolKey="dashboard-mq-consumer",
		    		threadPoolProperties = {
		            @HystrixProperty(name = "coreSize", value = "30"),//线程池大小
		            @HystrixProperty(name = "maxQueueSize", value = "100"),//最大队列长度
		            @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),//线程存活时间
		            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15")//拒绝请求
		    },
		    fallbackMethod = "fallback")
	public List<Product> getUsers() {
		System.out.println(Thread.currentThread().getName()+"11111");
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
	public List<Product> fallback(){
		System.out.println(Thread.currentThread().getName()+"22222");
		List<Product> list = new ArrayList<>();
		list.add(new Product(-1, "我是托底数据"));
		return list;
	}
	
	public void showThread(){
		System.out.println(Thread.currentThread().getName());
	}
}
