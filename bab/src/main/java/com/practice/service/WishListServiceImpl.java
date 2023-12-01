package com.practice.service;

import com.practice.domain.WishListDTO;
import com.practice.mapper.WishListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {
	
    @Autowired
    private WishListMapper wishListMapper;

    @Override
    public int insertWishList(int restaurantId,String userId) {
        return wishListMapper.insert(restaurantId,userId);
    }

    @Override
    public List<WishListDTO> getWishList(String userId) {
        return wishListMapper.getWishList(userId);
    }

    @Override
    public int deleteWishList(WishListDTO wishList) {
        return wishListMapper.delete(wishList);
    }

    @Override
    public int countWishList(int restaurantId) {
        return wishListMapper.countWishList(restaurantId);
    }
}
