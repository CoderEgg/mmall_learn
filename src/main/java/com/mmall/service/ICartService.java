package com.mmall.service;

import com.mmall.common.ServiceResponse;
import com.mmall.vo.CartVo;

public interface ICartService {
    //添加商品到购物车中
    ServiceResponse<CartVo> add(Integer userId, Integer count, Integer productId);
    //更新购物车中商品的数量
    ServiceResponse<CartVo> update(Integer userId, Integer count, Integer productId);
    //删除购物车中的商品
    ServiceResponse<CartVo> deleteProduct(Integer userId, String productIds);
    //显示购物车的商品
    ServiceResponse<CartVo> list(Integer userId);
    //全选或全反选
    ServiceResponse<CartVo> selectOrUnSelect(Integer userId,Integer productId, Integer checked);
    //获取购物车中的商品数量
    ServiceResponse<Integer> getCartProductCount(Integer userId);
}
