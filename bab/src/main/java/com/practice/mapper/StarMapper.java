package com.practice.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StarMapper {
	public double starAvg(int restaurantId);
}
