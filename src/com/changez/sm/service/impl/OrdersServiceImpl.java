package com.changez.sm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changez.sm.base.bean.Orders;
import com.changez.sm.mapper.OrdersMapper;
import com.changez.sm.service.OrdersService;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午7:26:20
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService{

	@Resource
	private OrdersMapper ordersmapper;
	@Override
	public List<Orders> queryOrderAndUser() {
		return ordersmapper.queryOrderAndUser();
	}
	@Override
	public List<Orders> queryOrderAndDetail() {
		List<Orders> a= ordersmapper.queryOrderAndDetail();
		System.out.println(a);
		List<Orders> b= ordersmapper.queryOrderAndDetail();
		System.out.println(b);
		return ordersmapper.queryOrderAndDetail();
	}

}
