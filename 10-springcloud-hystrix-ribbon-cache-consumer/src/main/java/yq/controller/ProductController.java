package yq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value="/get" ,method = RequestMethod.GET)
	public User get(Integer id){
		return  this.userService.getProductById(id);
	}

	@RequestMapping(value="/del" ,method = RequestMethod.GET)
	public void del(Integer id){
		this.userService.delProductById(id);
	}
}
