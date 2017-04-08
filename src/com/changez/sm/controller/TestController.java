package com.changez.sm.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cez.spring.controller.UserController;
import com.changez.sm.base.bean.User;
import com.changez.sm.base.result.Result;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月21日 下午3:09:10
 */
@Controller
@RequestMapping("/test/data/")
public class TestController {
	
	@Value("${cas_domain_name}")
	private String CAS_DOMAIN_NAME;
	
	@Autowired
	private UserController userController;
	
	@RequestMapping("http")
	@ResponseBody
	public Result httpTest(){
		Result result = new Result();
		Map<String, Object> map = new HashMap<String, Object>();
		String domainname;
		map.put("userType", "1");
		map.put("username", "username....");
		map.put("password", "password....");
		map.put("cas_domain_name", CAS_DOMAIN_NAME);
		result.setErrorInfo("test....");
		result.setErrorNo(0);
		result.setData(map);
		return result;
	}
	
	@RequestMapping("cookie")
	@ResponseBody
	public Result cookieTest(String num, String cookie) {
		Result result = new Result();
		Map<String, String> map = new HashMap<String, String>();
		map.put("num", num);
		map.put("cookie", cookie);
		String url = urlParamsStr(map);
		map.put("url", url);
		result.setData(map);
		return result;
	}
	
	@RequestMapping("urlTest")
	@ResponseBody
	public Result testUrl(String name, String cookie) {
		Result result = new Result();
		Map<String, Object> map = new HashMap<String, Object>();
		result.setData(map);
		return result;
	}
	
	private String urlParamsStr(Map<String, String> params) {
		 StringBuilder sb = new StringBuilder();
	        for (String key : params.keySet()) {
	        	String value = params.get(key);
//	        	if (!"cookie".equals(key)){		// cookie已经做过encode了，不要重复再做
	        		value = URLEncoder.encode(value);	
//	        	}
	            sb.append(key).append("=").append(value).append("&");
	        }
	        return sb.substring(0, sb.length() - 1);
	
	}
	
	@RequestMapping({"testmapping1", "testmapping2"})
	@ResponseBody
	public String testMapping(String name) {
		return name;
	}
	
	@RequestMapping("inner")
	@ResponseBody
	public String testInner() {
		return userController.getuserName();
	}
	
	@RequestMapping("interceptor")
	@ResponseBody
	public Object interceptor(String name) {
		System.out.println("name--------------->"+name);
		Map<String, String> retMap = new HashMap<String, String>();
		retMap.put("password", "222222");
		return retMap;
	}
	
	@RequestMapping("array")
	@ResponseBody
	public Object array(@RequestParam(value="name[]", required=false) String[] name,
			@RequestParam(value="address[]", required=false) Set<String> address, 
			String[] test) {
//		for (String attr : name) {
//			System.err.print(attr+",");
//		}
//		System.err.println();
//		for (String attr : address) {
//			System.err.print(attr+",");
//		}
//		System.err.println();
		for (String attr : test) {
			System.err.print(attr+",");
		}
		System.err.println();
//		System.err.println("name[].size:"+name.length +";   address[].size:"+address.size() + ";  test[].size:"+test.length);
		System.err.println("test[].size:"+test.length);
		return "xxxx";
	}
}
