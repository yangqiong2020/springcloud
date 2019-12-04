package yq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //刷新作用域
public class Config1Controller {

	@Value("${e-book}")
	private String msg;
	
	@RequestMapping("/showMsg")
	public String showMsg(){
		return this.msg;
	}
}
