package com.changez.sm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.changez.sm.base.bean.Movie;
import com.changez.sm.mapper.MovieMapper;
import com.changez.sm.service.MovieService;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月13日 下午5:14:52
 */
@Service
public class MovieServiceImpl implements MovieService{

	@Resource
	private MovieMapper movieMapper;

	@Override
	public Map<String, Object> queryMovieList(Integer curPage, Integer pageSize, Integer type) {
		
		int totalCount = queryMovieCountByType(type);
		List<Movie> movieList = new ArrayList<Movie>();
		// 已经显示的数量小于总数量才继续查询
		if((curPage-1) * pageSize < totalCount) {
			movieList = movieMapper.queryMovieList((curPage-1) * pageSize + 1, curPage * pageSize + 1, type);
			curPage += 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("curPage", curPage);
		map.put("totalCount", totalCount);
		map.put("data", movieList);
		return map;
	}

	@Override
	public int queryMovieCountByType(Integer type) {
		return movieMapper.queryMovieCountByType(type);
	}

	@Override
	public Movie queryMovieDetailById(Integer id) {
		if(id == null) {
			return null;
		}
		return movieMapper.queryMovieDetailById(id);
	}
}
