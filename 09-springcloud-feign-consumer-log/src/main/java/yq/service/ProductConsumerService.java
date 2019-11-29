package yq.service;

import org.springframework.cloud.netflix.feign.FeignClient;


@FeignClient(name="feign-provider")
public interface ProductConsumerService extends ProductService{

}
