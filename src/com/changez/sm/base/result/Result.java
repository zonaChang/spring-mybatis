package com.changez.sm.base.result;

import java.util.HashMap;
import java.util.Map;


/**
 * @desc: 当且仅当error_no为0， 表示数据调用成功； 
 * @auth: zona
 * 2017年2月18日 下午1:55:35
 */
public class Result extends HashMap{

	private int error_no;
	private String error_info;
	public Result () { }
	
	/**
	 * 设置错误号，错误信息
	 * @param error_no
	 * @param error_info
	 */
	public Result(int error_no, String error_info) {
		put("error_no", error_no);
		put("error_info", error_info);
	}
	
	/**
	 * 
	 * @desc: 设置错误号， controller调用成功时可以使用该方式。 等同于setErroNo方法
	 * @auth: zona
	 * 2017年2月19日 下午1:33:26
	 */
	public void success() {
		put("error_no", 0);
	}
	
	/**
	 * 
	 * @desc: 设置错误号
	 * @auth: zona
	 * 2017年2月19日 下午1:33:10 
	 * @param error_no
	 */
	public void setErrorNo(int error_no) {
		put("error_no", error_no);
	}
	
	/**
	 * 
	 * @desc: 设置错误信息
	 * @auth: zona
	 * 2017年2月19日 下午1:32:58 
	 * @param error_info
	 */
	public void setErrorInfo(String error_info) {
		put("error_info", error_info);
	}
	/**
	 * 
	 * @desc: 设置数据
	 * @auth: zona
	 * 2017年2月19日 下午1:32:33 
	 * @param data
	 */
	public void setData(Map data) {
		put("data", data);
	}
	
	//---> 调用方式
	public static void main(String[] args) {
		
		test();
	}
	
	/**
	 * 
	 * @desc: 调用方式
	 * @auth: zona
	 * 2017年2月19日 下午1:52:27 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public static Object test() {
		Result result = new Result();
		Map retMap = new HashMap();
		Object obj = null; // 获取数据1
		if(false) { // 检测数据，若数据是错误的
			retMap.put("user", obj);
			result.setErrorNo(1);
			result.setErrorInfo("错误信息。。。。");
			result.setData(retMap);
			return result;
		}
		
		Object obj2 = null; // 获取数据2
		if(false) { // 检测数据，若数据是错误的
			retMap.put("user", obj2);
			result.setErrorNo(1);
			result.setErrorInfo("错误信息。。。。");
			result.setData(retMap);
			return result;
		}
		// 流程都是正确的，封装返回数据
		retMap.put("user", obj);
		result.success();
		result.setData(retMap);
		return result;
	}
	
}
