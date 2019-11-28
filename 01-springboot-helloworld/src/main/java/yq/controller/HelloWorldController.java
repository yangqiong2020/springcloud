package yq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yq.exception.ApplicationException;

@RestController
public class HelloWorldController {
	
	@Value("${server.port}")
	private String msg;

	@RequestMapping("/hello")
	public String showMsg(){
		/*String str = null;
		str.length();*/
		//int a = 1/0;
		throw new ApplicationException("出错了");
		//return this.msg;
	}
}
