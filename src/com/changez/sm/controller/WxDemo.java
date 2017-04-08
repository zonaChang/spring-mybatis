package com.changez.sm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.changez.sm.base.bean.Customer;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月10日 上午9:42:38
 */
@Controller
@RequestMapping("/wx/demo/")
public class WxDemo {

	@RequestMapping("getDataFromBack")
	@ResponseBody
	public Customer getDataFromBack( String data) {
		System.out.println(data);
		Customer user = new Customer();
		user.setId(2l);
		user.setName("name-value");
		return user;
	}
	
	
}
