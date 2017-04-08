package com.changez.sm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changez.sm.base.bean.Customer;
import com.changez.sm.mapper.CustomerMapper;
import com.changez.sm.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerMapper customerMapper;
	
	@Override
	public void insertUser(Customer user, Customer user1) {
		customerMapper.insertUser(user);
		System.out.println("1222");
		int a = 4/0;
		customerMapper.insertUser(user1);
		System.out.println(333);
		
	}

	@Override
	public Customer login(Customer user) {
		return customerMapper.login(user);
	}

	
}
