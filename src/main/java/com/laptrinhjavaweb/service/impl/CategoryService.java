package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.dao.impl.CategoryDao;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    private ICategoryDao categoryDao;
    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }
}
