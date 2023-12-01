package com.practice.service;

import java.util.List;

import com.practice.domain.ReviewDTO;

public interface ReviewService {
	public List<ReviewDTO> getList(int restauantId);
	public boolean insert(ReviewDTO dto);
	public boolean update(ReviewDTO dto);
	public ReviewDTO read(int reviewId);
	public boolean delete(int reviewId);	
}
