package com.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.book.trade.service.TradeService;

/**
 * 调用交易服务
 * @author Administrator
 *
 */
@FeignClient("e-book-trade-provider")
public interface ConsumerTradeService extends TradeService {

}
