package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.NewModel;


import java.util.List;

public interface INewDao extends GenericDao<NewModel> {
    NewModel findOne(Long id);
    List<NewModel> findByCategoryId(Long categoryid);
    Long save(NewModel newModel);
    void update(NewModel updateNew);
    void delete(long id);
    List<NewModel> findAll(Integer offset, Integer limit);
    int getTotalItem();
}
