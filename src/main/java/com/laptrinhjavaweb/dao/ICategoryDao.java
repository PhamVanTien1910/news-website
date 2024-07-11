package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.CategoryModel;

import java.util.List;

public interface ICategoryDao extends GenericDao<CategoryModel> {
    List <CategoryModel> findAll();
    CategoryModel findOne(Long id);
    CategoryModel findOneByCode(String code);
}
