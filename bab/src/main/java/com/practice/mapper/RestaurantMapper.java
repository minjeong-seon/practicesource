package com.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.domain.RestaurantDTO;

@Mapper
public interface RestaurantMapper {
	public int insert(RestaurantDTO restaurant);
	public List<RestaurantDTO> checkRestaurant(String title, String address);
}
