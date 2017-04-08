package com.changez.sm.service;

import com.changez.sm.base.bean.Customer;

public interface CustomerService {

	public Customer login(Customer user);
	public void insertUser(Customer user, Customer user1);
}
