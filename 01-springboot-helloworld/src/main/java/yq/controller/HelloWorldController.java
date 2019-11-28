package yq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Value("${server.port}")
	private String msg;

	@RequestMapping("/hello")
	public String showMsg(){
		return this.msg;
	}
}
