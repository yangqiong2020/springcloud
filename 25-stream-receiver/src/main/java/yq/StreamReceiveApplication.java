package yq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;


@SpringBootApplication
@EnableEurekaClient
@EnableBinding(value={IReceiveService.class})
public class StreamReceiveApplication {
	public static void main(String[] args) {
		SpringApplication.run(StreamReceiveApplication.class, args);
	}
}
