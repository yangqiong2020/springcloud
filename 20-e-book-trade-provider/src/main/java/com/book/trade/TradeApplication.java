package com.book.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.book.trade.mapper")
public class TradeApplication {
	public static void main(String[] args) {
		SpringApplication.run(TradeApplication.class, args);
	}
}
