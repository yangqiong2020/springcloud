package com.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.book.user.service.UserService;

/**
 * 调用User服务
 * @author Administrator
 *
 */
@FeignClient("e-book-user-provider")
public interface ConsumerUserService extends UserService {

}
