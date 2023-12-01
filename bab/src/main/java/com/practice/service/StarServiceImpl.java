package com.practice.service;

import org.springframework.stereotype.Service;

import com.practice.mapper.StarMapper;
@Service
public class StarServiceImpl implements StarService {

	private StarMapper mapper;
	
	@Override
	public double starAvg(int restaurantId) {
		// 음식점 별점 평균
		Double starAvg = mapper.starAvg(restaurantId);
		return starAvg;
		
	}

}
