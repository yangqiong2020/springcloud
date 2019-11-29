package yq.service;

import org.springframework.cloud.netflix.feign.FeignClient;


@FeignClient(name="feign-provider") //通过这里来判断调用这个接口的哪个实现类
public interface ProductConsumerService extends ProductService{

}
