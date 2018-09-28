package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServiceResponse;
import com.mmall.pojo.Shipping;

public interface IShippingService {
    //新增收货地址
    ServiceResponse add(Integer userId, Shipping shipping);
    //删除一个收货地址
    ServiceResponse<String> del(Integer userId, Integer shippingId);
    //更新某个地址信息
    ServiceResponse<String> update(Integer userId, Shipping shipping);
    //查询某个地址信息
    ServiceResponse<Shipping> select(Integer userId, Integer shippingId);
    //查询用户的所有地址信息
    ServiceResponse<PageInfo> list(Integer userId, Integer pageNum , Integer pageSize);
}
