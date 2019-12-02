package com.book.user.service;

import com.book.user.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User服务接口
 * 
 * @author Administrator
 *
 */
@RequestMapping("/user")
public interface UserService {
	// 用户登录
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(@RequestParam("userName") String userName, @RequestParam("password") String password);
}
