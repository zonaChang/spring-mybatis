package com.changez.sm.mapper;

import java.util.List;

import com.changez.sm.base.bean.User;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午5:37:41
 */
public interface UserMapper {

	public User getUserById(String id);
	
	public List<User> getAllUser();

	public User queryUserAndItems();

	public void addUser(User user);
}
