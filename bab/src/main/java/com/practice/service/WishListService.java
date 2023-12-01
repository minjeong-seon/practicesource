package com.practice.service;

import com.practice.domain.WishListDTO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WishListService {
    public int insertWishList(@Param("restaurantId")int restaurantId,@Param("userId")String userId);
    public List<WishListDTO> getWishList(String userId);
    public int deleteWishList(WishListDTO wishList);
    public  int countWishList(int restaurantId);
}

