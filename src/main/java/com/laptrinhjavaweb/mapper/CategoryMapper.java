package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel>{
    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        try {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setId(resultSet.getLong("id"));
            categoryModel.setCode(resultSet.getString("code"));
            categoryModel.setName(resultSet.getString("name"));
            return categoryModel;
        } catch (SQLException e) {
            return null;
        }

    }
}
