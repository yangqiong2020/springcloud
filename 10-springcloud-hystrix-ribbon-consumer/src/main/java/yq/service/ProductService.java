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
import yq.pojo.User;

@Service
public class ProductService {

	@Autowired
	private LoadBalancerClient loadBalancerClient;// ribbon负载均衡器

	@HystrixCommand(fallbackMethod="fallback")
	public List<User> getUsers() {
		// 选择调用的服务的名称
		// ServiceInstance 封装了服务的基本信息，如 IP，端口
		ServiceInstance si = this.loadBalancerClient.choose("hystrix-ribbon-provider");
		// 拼接访问服务的URL
		StringBuffer sb = new StringBuffer();
		// http://localhost:9001/product/findAll
		sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/user");
		System.out.println(sb.toString());
		// springMVC RestTemplate
		RestTemplate rt = new RestTemplate();

		ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>() {
		};

		// ResponseEntity:封装了返回值信息
		ResponseEntity<List<User>> response = rt.exchange(sb.toString(), HttpMethod.GET, null, type);
		List<User> list = response.getBody();
		return list;
	}
	
	//返回托底数据的方法
	public List<User> fallback(){
		List<User> list = new ArrayList<>();
		list.add(new User(-1, "我是托底数据",100));
		return list;
	}
}
