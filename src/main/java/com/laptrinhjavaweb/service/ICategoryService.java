package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
}
