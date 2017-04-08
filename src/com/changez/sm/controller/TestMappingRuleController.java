package com.changez.sm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changez.sm.base.bean.User;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月16日 下午1:59:03
 */
@Controller
@RequestMapping("test/mapping")
public class TestMappingRuleController {

	@RequestMapping("testmethod")
	@ResponseBody
	public List<String> testMappingUrl() {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		return list;
	}
}
