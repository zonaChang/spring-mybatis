package com.changez.sm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changez.sm.base.bean.Movie;
import com.changez.sm.service.MovieService;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月13日 下午4:36:37
 */
@Controller
@RequestMapping("/movie/")
public class MovieController {

	@Resource
	private MovieService movieService;
	
	@RequestMapping("queryMovieList")
	@ResponseBody
	public Map<String, Object> queryMovieList(Integer curPage, Integer pageSize, Integer type) {
		if(curPage == null || curPage < 1) {
			curPage = 1;
		}
		if(pageSize == null || pageSize < 0) {
			pageSize = 10;
		}
		Map<String, Object> map = movieService.queryMovieList(curPage, pageSize, type);
		return map;
	}
	
	@RequestMapping("queryMovieDetailById")
	@ResponseBody
	public Movie queryMovieDetailById(Integer id) {
		return movieService.queryMovieDetailById(id);
	}
}
