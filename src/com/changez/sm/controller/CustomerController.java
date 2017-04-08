package com.changez.sm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changez.sm.base.bean.Customer;
import com.changez.sm.service.CustomerService;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月6日 下午1:45:26
 */
@Controller
@RequestMapping("/customer/test/")
public class CustomerController {

	@Resource
	private CustomerService customerService;
	
	@RequestMapping("login")
//	@ResponseBody
	public String login(Customer user) {
		user = customerService.login(user);
		//--->跳转到页面
		// 重定向到页面（不能重定向到web-inf下面,且不会携带参数），
		// 如果不以“/”开头，默认为当前controller类上的@RequestMapping("")的值+重定向的值
		// 访问的是webContent下的redirectSuccess.jsp页面
		// return user != null ? "redirect:/redirectSuccess.jsp" : "redirect:/redirectFail.jsp";
		
		// 访问的是webContent下的user/test下的redirectSuccess.jsp页面
		// return user != null ? "redirect:redirectSuccess.jsp" : "redirect:redirectFail.jsp";
		
		// 转发到页面， 携带参数， 浏览器地址栏不变化
		// return user != null ? "forward:/forwardSuccess.jsp" : "forward:/forwardFail.jsp";
		
		// 转发到web-inf下的页面
		// return user != null ? "forward:/WEB-INF/jsp/web_forwardSuccess.jsp" : "forward:/WEB-INF/jsp/web_forwardFail.jsp";
		
		//--->跳转到controller
		
		// 跳转当前controller中的其他方法
		// return "forward:redirectFunc";
		
		//跳转到其他controller中的方法
		return "forward:/user/test/redirectFunc";
	}
	
	@RequestMapping("redirectFunc")
	public String redirectFunc(Customer user) {
		System.out.println("UserController.redirectFunc()");
		return  "";
	}
	
	public String forwardFunc(Customer user) {
		System.out.println("UserController.forwardFunc()");
		return "";
	}
	
}
