package com.changez.sm.service;

import java.util.List;

import com.changez.sm.base.bean.Orders;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午7:24:52
 */
public interface OrdersService {

	List<Orders> queryOrderAndUser();

	List<Orders> queryOrderAndDetail();

}
