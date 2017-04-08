package com.changez.sm.mapper;

import com.changez.sm.base.bean.Customer;

public interface CustomerMapper {

	public Customer login(Customer user);
	
	public void insertUser(Customer user);
}
