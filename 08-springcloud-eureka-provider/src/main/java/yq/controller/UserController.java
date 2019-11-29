package yq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yq.pojo.User;

@RestController
public class UserController {

	@RequestMapping("/user")
	public List<User> getUsers(){
		List<User> list = new ArrayList<>();
		list.add(new User(1,"111",211));
		list.add(new User(2,"111",2211));
		list.add(new User(3,"111",20222));
		return list;
	}
}
