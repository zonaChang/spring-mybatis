package com.changez.sm.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @desc: 
 * @auth: zona
 * 2017年3月14日 下午7:45:25
 */
public class TimeInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");
		String startTime = "0930";
		String endTime = "2330";
		String nowTime = dateFormat.format(new Date());
		if(nowTime.compareTo(startTime) < 0 || endTime.compareTo(nowTime) < 0) {
			return false;
		}
		return true;
	}
}
