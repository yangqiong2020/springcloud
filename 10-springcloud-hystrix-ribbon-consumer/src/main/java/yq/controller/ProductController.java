package yq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yq.pojo.User;
import yq.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService userService;
	
	@RequestMapping("/consumer")
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
}
