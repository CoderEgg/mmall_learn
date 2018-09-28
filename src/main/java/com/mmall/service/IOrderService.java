package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServiceResponse;
import com.mmall.vo.OrderVo;

import java.util.Map;

public interface IOrderService {
    //预下单，生成支付宝二维码
    ServiceResponse pay(Long orderNo, Integer userId, String path);
    //支付宝回调
    ServiceResponse aliCallback(Map<String,String> params);
    //查询支付状态
    ServiceResponse queryOrderPayStatus(Integer userId, Long orderNo);
    //创建订单
    ServiceResponse createOrder(Integer userId, Integer shippingId);
    //取消订单
    ServiceResponse<String> cancel(Integer userId, Long orderNo);
    //获取订单中的商品详情
    ServiceResponse getOrderCartProduct(Integer userId);
    //获取用户某个订单的商品详情
    ServiceResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);
    //查询某用户的所有订单
    ServiceResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
    //管理员查询所有订单
    ServiceResponse<PageInfo> manageList(int pageNum, int PageSize);
    //管理员获取订单详情
    ServiceResponse<OrderVo> manageDetail(Long orderNo);
    //后台搜索功能
    ServiceResponse<PageInfo> manageSearch(Long orderNo, int pageNum , int pageSize);
    //管理员发货
    ServiceResponse<String> manageSendGoods(Long orderNo);
}
