package com.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.book.order.service.OrderService;

/**
 * 调用订单服务
 * @author Administrator
 *
 */
@FeignClient("e-book-order-provider")
public interface ConsumerOrderService extends OrderService {

}
