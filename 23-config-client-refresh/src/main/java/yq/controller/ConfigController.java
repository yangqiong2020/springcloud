package yq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RefreshScope
public class ConfigController {

	@Value("${e-book}")
	private String msg;

	@Value("${datasource.username}")
	private String username;
	
	@RequestMapping("/showMsg")
	public String showMsg(){
		return this.msg+"  "+this.username;
	}
}
