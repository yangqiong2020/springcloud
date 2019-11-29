package yq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yq.pojo.User;
import yq.service.ProductService;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@RestController
public class ProductController {

	@Autowired
	private ProductService userService;
	
	@RequestMapping("/consumer")
	public void getUsers() throws ExecutionException, InterruptedException {
		Future<User> p1 = this.userService.getProduct(1);
		Future<User> p2 = this.userService.getProduct(2);
		Future<User> p3 = this.userService.getProduct(3);
		System.out.println(p1.get().toString());
		System.out.println(p2.get().toString());
		System.out.println(p3.get().toString());
	}
}
