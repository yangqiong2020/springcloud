package yq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ConfigController {

	@Value("${e-book}")
	private String msg;

	//获取对称加密的字符
	@Value("${datasource.password}")
	private String username;

	//获取对称加密的字符

	@RequestMapping("/showMsg")
	public String showMsg(){
		return this.msg+this.username;
	}
}
