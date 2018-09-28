package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServiceResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

public interface IProductService {
    //保存或更新产品
    ServiceResponse saveOrUpdateProduct(Product product);
    //产品的上架与下架
    ServiceResponse<String> setSaleStatus(Integer productId, Integer status);
    //获取产品信息详情
    ServiceResponse<ProductDetailVo> manageProductDetail(Integer productId);
    //获取产品列表
    ServiceResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize );
    //搜索产品
    ServiceResponse<PageInfo> searchProduct(String productName, Integer paoructId, Integer pageNum, Integer pageSize);
    //portal
    //产品详情
    ServiceResponse<ProductDetailVo> getProductDetail(Integer productId);
    //搜索查询
    ServiceResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId ,Integer pageNum,Integer pageSize,String orderBy);
}
