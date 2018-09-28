package com.mmall.service.impl;


import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.common.ServiceResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServiceResponse addCategory(String categoryName, Integer parentId) {
        if(parentId == null || StringUtils.isBlank(categoryName)){
            return ServiceResponse.createByErrorMessage("添加品类参数错误，");
        }
        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true); //这个分类是有用的

        int insertCount = categoryMapper.insert(category);
        if(insertCount > 0){
            return ServiceResponse.createBySuccess("添加品类成功");
        }
        return ServiceResponse.createByErrorMessage("添加品类失败");
    }

    @Override
    public ServiceResponse updateCategoryName(Integer categoryId, String categoryName) {
        if(categoryId == null || StringUtils.isBlank(categoryName)){
            return ServiceResponse.createByErrorMessage("更新品类参数错误，");
        }
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        int updateCount = categoryMapper.updateByPrimaryKeySelective(category);
        if(updateCount > 0){
            return ServiceResponse.createBySuccess("更新品类名称成功");
        }
        return ServiceResponse.createByErrorMessage("更新品类名称失败");
    }

    @Override
    public ServiceResponse<List<Category>> getChildrenParallelCategory(Integer categoryId) {
        if(categoryId == null){
            return ServiceResponse.createByErrorMessage("查询参数错误");
        }
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        if(CollectionUtils.isEmpty(categoryList)){
            logger.info("未找到当前分类的子分类");
        }
        return ServiceResponse.createBySuccess(categoryList);
    }

    /**
     * 递归查询本节点id以及子节点id
     * @param categoryId
     * @return
     */
    @Override
    public ServiceResponse<List<Integer>> selectCategoryAndChildrenCategory(Integer categoryId) {
        Set<Category> categorySet = Sets.newHashSet();
        findChindCategory(categorySet,categoryId);
        List<Integer> categoryIdList = Lists.newArrayList();
        if(categoryId != null){
            for(Category categoryItem :categorySet){
                categoryIdList.add(categoryItem.getId());
            }
        }
        return ServiceResponse.createBySuccess(categoryIdList);
    }
    //递归算法，算出子节点
    private Set<Category> findChindCategory(Set<Category> categorySet,Integer categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if(category != null){
            categorySet.add(category);
        }
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        for(Category categoryItem : categoryList){
            findChindCategory(categorySet,categoryItem.getId());
        }
        return categorySet;
    }
}
