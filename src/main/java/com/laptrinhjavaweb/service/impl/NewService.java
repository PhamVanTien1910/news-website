package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.dao.INewDao;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewService implements INewService {
    @Inject
    private INewDao newDao;
    @Inject
    private ICategoryDao categoryDao;

    @Override
    public List<NewModel> findByCategoryId(Long categoryid) {
        return newDao.findByCategoryId(categoryid);
    }

    @Override
    public NewModel save(NewModel newModel) {
        newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        CategoryModel category = categoryDao.findOneByCode(newModel.getCategoryCode());
        newModel.setCategoryid(category.getId());
        newModel.setCreatedBy("");
        Long newId = newDao.save(newModel);
        return newDao.findOne(newId);
    }

    @Override
    public NewModel update(NewModel updateNew) {
        NewModel oldNew = newDao.findOne(updateNew.getId());
        updateNew.setCreatedBy(oldNew.getCreatedBy());
        updateNew.setCreatedDate(oldNew.getCreatedDate());
        updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        CategoryModel category = categoryDao.findOneByCode(updateNew.getCategoryCode());
        updateNew.setCategoryid(category.getId());
        newDao.update(updateNew);
        NewModel updatedModel = newDao.findOne(updateNew.getId());
        return updatedModel;
    }

    @Override
    public void delete(Long[] ids) {
        for (long id : ids) {
            newDao.delete(id);
        }
    }

    @Override
    public List<NewModel> findAll(Integer offset, Integer limit) {
        return newDao.findAll(offset, limit);
    }

    @Override
    public int getTotalItem() {
        return newDao.getTotalItem();
    }

    @Override
    public NewModel findOne(Long id) {
        NewModel newModel = newDao.findOne(id);
        CategoryModel categoryModel = categoryDao.findOne(newModel.getCategoryid());
        newModel.setCategoryCode(categoryModel.getCode());
        return newModel;
    }
}
