package com.changez.sm.mapper;

import java.util.List;

import com.changez.sm.base.bean.Movie;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月13日 下午5:16:28
 */
public interface MovieMapper {

	public List<Movie> queryMovieList(int curPage, int pageSize, Integer type);

	public int queryMovieCountByType(Integer type);

	public Movie queryMovieDetailById(Integer id);

}
