package com.changez.sm.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.changez.sm.base.bean.Customer;
import com.changez.sm.mapper.CustomerMapper;
import com.changez.sm.service.CustomerService;
import com.changez.sm.service.impl.CustomerServiceImpl;

public class CustomerControllerTest {

	private CustomerMapper userMapper = null;
	private CustomerService userService;
	
	@Before
	public void Init() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (CustomerService) context.getBean("userServiceImpl");
		userMapper = (CustomerMapper) context.getBean("userMapper");
	}
	
	@Test
	public void query() {
		
		Customer user = new Customer();
		user.setName("changez");
		user.setPassword("changez");
		System.out.println(userMapper.login(user));
	}
	
	@Test
	public void insert() {
		Customer user = new Customer();
		user.setName("zonax1");
		user.setPassword("zonapx1");
		userMapper.insertUser(user);
		int a = 4/0;
		Customer user2 = new Customer();
		user2.setName("zonax2");
		user2.setPassword("zonapx2");
		userMapper.insertUser(user);
		System.out.println();
	}
	
	@Test
	public void serviceInsert() {
		
		Customer user = new Customer();
		user.setName("zonax1");
		user.setPassword("zonapx1");
		Customer user2 = new Customer();
		user2.setName("zonax2");
		user2.setPassword("zonapx2");
		userService.insertUser(user, user2);
	}
	
}
