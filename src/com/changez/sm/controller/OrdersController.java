package com.changez.sm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changez.sm.base.bean.Orders;
import com.changez.sm.mapper.OrdersMapper;
import com.changez.sm.service.OrdersService;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午7:22:55
 */
@Controller
@RequestMapping("/orders/")
public class OrdersController {

	@Resource
	private OrdersService ordersService;
	
	@Resource
	private OrdersMapper ordersMapper;
	public List<Orders> queryOrderAndUser(){
		return ordersService.queryOrderAndUser();
	}
	
	public List<Orders> queryOrderAndDetail() {
		
		return ordersService.queryOrderAndDetail();
	}

	public Orders queryOrderAndUserLoading() {
		return ordersMapper.queryOrderAndUserLoading();
	}
}
