package com.changez.sm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changez.sm.base.bean.User;
import com.changez.sm.base.bean.ValidBean;
import com.changez.sm.base.bean.group.user.UserGroup1;
import com.changez.sm.base.result.Result;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月17日 下午3:21:20
 */
@Controller
@RequestMapping("/test/")
public class ValidTestController {

	/**
	 * 
	 * @desc: 校验没有分组的属性
	 * @auth: zona
	 * 2017年2月19日 下午2:35:42 
	 * @param bean
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("valid")
	@ResponseBody
	public Result testValid(@Validated ValidBean bean, BindingResult bindingResult) {
		Result result = new Result();
		Map retMap = new HashMap();
		StringBuilder sb = new StringBuilder();
		if(bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError err : errors) {
				sb.append(err.getDefaultMessage()+";  ");
			}
			result.setErrorInfo(sb.toString());
			result.setErrorNo(1);
			 return result;
		}
		retMap.put("bean", bean);
		result.success();
		result.setData(retMap);
		return result;
	}
	
	/**
	 * 
	 * @desc: 仅对属于userGroup组的属性进行校验
	 * @auth: zona
	 * 2017年2月19日 下午2:37:03 
	 * @param bean
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("group/valid")
	@ResponseBody
	public Result testGroupValid(@Validated(value=UserGroup1.class) ValidBean bean, BindingResult bindingResult) {
		Result result = new Result();
		Map retMap = new HashMap();
		StringBuilder sb = new StringBuilder();
		if(bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError err : errors) {
				sb.append(err.getDefaultMessage()+";  ");
			}
			result.setErrorInfo(sb.toString());
			result.setErrorNo(1);
			 return result;
		}
		retMap.put("bean", bean);
		result.success();
		result.setData(retMap);
		return result;
	}
	
	@RequestMapping("json")
	@ResponseBody
	public Result jsonTest() {
		Result result = new Result();
		String[] array = {"a", "b", "34"};
		List<String> list = new ArrayList<String>();
		list.add("list_a");
		list.add("list_b");
		list.add("list_c");
		Map<String, String> map = new HashMap<String, String>();
		map.put("map1", "key1");
		map.put("map2", "key2");
		map.put("map3", "key3");
		
		User user = new User();
		user.setAddress("addressxxxx");
		user.setId("idxxx");
		user.setUsername("usernamexxx");
		
		User user2 = new User();
		user2.setAddress("addressxxxx2");
		user2.setId("idxxx2");
		user2.setUsername("usernamexxx2");
		
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user2);
		
		Map<String, List<User>> userMap = new HashMap<String, List<User>>();
		userMap.put("usermap1", userList);
		
		
//		JSONArray json = JSONArray.fromObject(array);
		result.put("err_no", 0);
		result.put("err_info", "错误信息。。。");
//		result.put("data", json);
		result.put("list", list);
		result.put("map", map);
		result.put("boolean", true);
		result.put("user", user);
		result.put("userList", userList);
		result.put("usermap", userMap);
		return result;
	}
}
