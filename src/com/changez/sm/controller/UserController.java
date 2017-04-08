package com.changez.sm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changez.sm.base.bean.User;
import com.changez.sm.mapper.UserMapper;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午5:41:09
 */
@Controller
@RequestMapping("/user/")
public class UserController {

	@Resource
	private UserMapper userMapper;
	
	@RequestMapping("getUserById")
	public User getUserById(String id) {
		return userMapper.getUserById(id);
	}

	public List<User>getAllUser() {
		return userMapper.getAllUser();
	}

	public User queryUserAndItems() {
		return userMapper.queryUserAndItems();
	}

	public void addUser(User user) {
		userMapper.addUser(user);
		System.out.println(user);
	}
}
