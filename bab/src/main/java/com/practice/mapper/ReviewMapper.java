package com.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.domain.ReviewDTO;

@Mapper
public interface ReviewMapper {
	public List<ReviewDTO> ReviewList(int restauantId);
	public int insert(ReviewDTO dto);
	public int update(ReviewDTO dto);
	public ReviewDTO read(int reviewId);
	public int delete(int reviewId);
}
