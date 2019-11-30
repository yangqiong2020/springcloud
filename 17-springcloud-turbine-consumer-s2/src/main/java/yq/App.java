package yq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrixDashboard  //开启dashboard支持
@EnableCircuitBreaker //开始熔断支持
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
