package com.mmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServiceResponse;
import com.mmall.dao.ShippingMapper;
import com.mmall.pojo.Shipping;
import com.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public ServiceResponse add(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        int rowCount = shippingMapper.insert(shipping);
        if(rowCount > 0){
            Map resultMap = Maps.newHashMap();
            resultMap.put("shippingId",shipping.getId());
            return ServiceResponse.createBySuccess("地址添加成功",resultMap);
        }else{
            return ServiceResponse.createByErrorMessage("地址添加失败");
        }
    }

    @Override
    public ServiceResponse<String> del(Integer userId, Integer shippingId) {
        if(userId == null || shippingId == null){
            return ServiceResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        int rowCount  = shippingMapper.deleteByShippingIdUserId(userId,shippingId);
        if(rowCount > 0){
            return ServiceResponse.createBySuccess("删除地址成功");
        }else{
            return ServiceResponse.createByErrorMessage("删除地址失败");
        }
    }
    public ServiceResponse<String> update(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        int rowCount = shippingMapper.updateByShipping(shipping);
        if(rowCount > 0){
            return ServiceResponse.createBySuccess("地址更新成功");
        }else{
            return ServiceResponse.createByErrorMessage("地址更新失败");
        }
    }
    public ServiceResponse<Shipping> select(Integer userId, Integer shippingId){
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId, shippingId);
        if(shipping != null) {
            return ServiceResponse.createBySuccess(shipping);
        }else{
            return ServiceResponse.createByErrorMessage("无法查询该地址");
        }
    }
    public ServiceResponse<PageInfo> list(Integer userId, Integer pageNum ,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServiceResponse.createBySuccess(pageInfo);
    }
}
