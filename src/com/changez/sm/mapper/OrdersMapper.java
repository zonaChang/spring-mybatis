package com.changez.sm.mapper;

import java.util.List;

import com.changez.sm.base.bean.Orders;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午7:27:21
 */
public interface OrdersMapper {

	List<Orders> queryOrderAndUser();

	List<Orders> queryOrderAndDetail();

	Orders queryOrderAndUserLoading();

}
