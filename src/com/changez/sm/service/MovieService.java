package com.changez.sm.service;

import java.util.List;
import java.util.Map;

import com.changez.sm.base.bean.Movie;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月13日 下午5:11:09
 */
public interface MovieService {

	public Map<String, Object> queryMovieList(Integer curPage, Integer pageSize, Integer type);

	public int queryMovieCountByType(Integer type);

	public Movie queryMovieDetailById(Integer id);

}
