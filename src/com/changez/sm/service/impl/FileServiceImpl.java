package com.changez.sm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.changez.sm.base.bean.Movie;
import com.changez.sm.mapper.FileMapper;
import com.changez.sm.service.FileService;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月17日 上午10:12:17
 */
@Service
public class FileServiceImpl implements FileService{

	@Resource
	private FileMapper fileMapper;
	@Override
	public void saveFiles(List<Movie> movieList) {
		if(movieList == null || movieList.size() == 0) {
			return ;
		}
		fileMapper.saveFiles(movieList);
	}

}
