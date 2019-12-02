package com.book.user.service;

import com.book.user.mapper.UserMapper;
import com.book.user.pojo.User;
import com.book.user.pojo.UserExample;
import com.book.user.pojo.UserExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

	@Autowired
	private UserMapper userMapper;
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public User userLogin(String userName ,String password){
		UserExample example = new UserExample();
		Criteria cri = example.createCriteria();
		cri.andUserNameEqualTo(userName);
		cri.andPasswordEqualTo(password);
		List<User> list=this.userMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
		
	}
}
