package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;

import java.util.List;

public class CategoryDao extends AbstractDao<CategoryModel> implements ICategoryDao {

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }

    @Override
    public CategoryModel findOne(Long id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        List<CategoryModel> categoryModels = query(sql, new CategoryMapper(), id);
        return categoryModels.isEmpty() ? null : categoryModels.get(0);
    }

    @Override
    public CategoryModel findOneByCode(String code) {
        String sql = "SELECT * FROM category WHERE code = ?";
        List<CategoryModel> categoryModels = query(sql, new CategoryMapper(), code);
        return categoryModels.isEmpty() ? null : categoryModels.get(0);
    }
}
