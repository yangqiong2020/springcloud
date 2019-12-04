package com.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.book.product.service.ProductService;
/**
 * 调用product服务
 * @author Administrator
 *
 */
@FeignClient("sleuth-zipkin-mq-product-provider")
public interface ConsumerProductService extends ProductService {

}
