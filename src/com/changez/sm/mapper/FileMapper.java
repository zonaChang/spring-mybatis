package com.changez.sm.mapper;

import java.util.List;

import com.changez.sm.base.bean.Movie;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月17日 上午10:13:11
 */
public interface FileMapper {

	public void saveFiles(List<Movie> movieList);
}
