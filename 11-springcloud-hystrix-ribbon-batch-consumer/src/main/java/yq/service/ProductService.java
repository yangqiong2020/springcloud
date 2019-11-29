package yq.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import yq.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class ProductService {

	//利用hystrix合并请求
	@HystrixCollapser(batchMethod = "batchProduct", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
			collapserProperties = {
					//请求时间间隔在5s之内的请求会被合并为一个请求,默认为10ms
					@HystrixProperty(name = "timerDelayInMilliseconds", value = "5000"),
					//设置触发批处理执行之前，在批处理中允许的最大请求数。
					@HystrixProperty(name = "maxRequestsInBatch", value = "200"),
			})
	//consumer的controller调用的方法 该方法返回值必须要返回Future类型
	public Future<User> getProduct(Integer id){
		System.out.println("=========="+id+"==========");
		return null;
	}

	@HystrixCommand
	//调用Provider服务的方法
	public List<User> batchProduct(List<Integer> ids){
		for(Integer id:ids){
			System.out.println(id);
		}
		//假设是调用provider服务后返回的list
		List<User> list = new ArrayList<>();
		list.add(new User(1, "电视",100));
		list.add(new User(2, "电脑",101));
		list.add(new User(3, "冰箱",102));
		list.add(new User(4, "手电筒",103));
		list.add(new User(100,"list............",103));
		System.out.println("ddddddddddddddddddddddd");
		return list;
	}
}
