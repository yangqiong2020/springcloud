package com.book.trade.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.book.order.service.OrderService;
@FeignClient("e-book-order-provider")
public interface ProviderOrderService extends OrderService {

}
