package com.changez.sm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.changez.sm.base.bean.Customer;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月11日 上午9:39:15
 */
@Controller
@RequestMapping("/wxdemo/demo/")
public class WxDemoPullDownController {
	
	@RequestMapping("queryUser")
	@ResponseBody
	public Map<String, Object> queryUser(Integer currentPage, Integer pageSize) {
		if(currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		if(pageSize == null || pageSize <= 0 ) {
			pageSize = 10;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Customer> users = this.createUserList();
		int endIndex = currentPage * pageSize;
		if(endIndex > users.size()) {
			endIndex = users.size();
		}
		map.put("currentPage", currentPage);

		
		List<Customer> curUsers = users.subList((currentPage-1) * pageSize, endIndex);
		map.put("userList", curUsers);
		return map;
	}
	
	@RequestMapping("testmv")
	@ResponseBody
	public Model testMv( Model model) {
		model.addAttribute("key", "value");
		return model;
	}
	private List<Customer> createUserList(){
		List<Customer> users = new ArrayList<Customer>();
		for (long i =0 ; i< 55; i++) {
			Customer user = new Customer(i, "name"+i, i);
			users.add(user);
		}
		return users;
	}
}
