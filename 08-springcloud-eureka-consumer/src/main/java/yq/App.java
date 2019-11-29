package yq;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class App {
    //修改rabbin的负债均衡策略
    @Bean
    public RandomRule createRule()
    {
        return new RandomRule();
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
