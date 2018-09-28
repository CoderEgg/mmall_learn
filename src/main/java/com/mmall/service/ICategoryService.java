package com.mmall.service;

import com.mmall.common.ServiceResponse;

import java.util.List;

public interface ICategoryService {
    //添加分类
    ServiceResponse addCategory(String categoryName,Integer parentId);
    //修改分类名称
    ServiceResponse updateCategoryName(Integer categoryId, String categoryName);
    //查询子节点分类信息
    ServiceResponse getChildrenParallelCategory(Integer categoryId);
    //递归查询子分类
    ServiceResponse<List<Integer>> selectCategoryAndChildrenCategory(Integer categoryId);
}
