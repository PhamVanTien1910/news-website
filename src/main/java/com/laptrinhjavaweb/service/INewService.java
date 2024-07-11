package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.NewModel;

import javax.enterprise.inject.New;
import java.util.List;

public interface INewService {
    List<NewModel> findByCategoryId(Long categoryid);
    NewModel save(NewModel newModel);
    NewModel update(NewModel updateNew);
    void delete(Long[] ids);
    List<NewModel> findAll(Integer offset, Integer limit);
    int getTotalItem();
    NewModel findOne (Long id);
}
