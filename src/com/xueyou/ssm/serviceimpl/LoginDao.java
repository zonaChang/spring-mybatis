package com.xueyou.ssm.serviceimpl;

import java.util.List;
import java.util.Map;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月21日 下午12:47:32
 */
public interface LoginDao {

	List<Map<String, Object>> login(Map<String, Object> params);

}
