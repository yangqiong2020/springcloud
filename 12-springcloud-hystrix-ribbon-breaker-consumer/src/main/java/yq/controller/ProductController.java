package yq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yq.pojo.Product;
import yq.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService userService;
	
	@RequestMapping("/consumer")
	public List<Product> getUsers(@RequestParam("flag") Integer flag){
		return this.userService.getUsers(flag);
	}
}
