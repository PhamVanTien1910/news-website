package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.INewDao;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;

import java.sql.*;
import java.util.List;

public class NewDao extends AbstractDao<NewModel> implements INewDao {
    @Override
    public void update(NewModel updateNew) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?, ");
        sql.append("shortDescription = ?, content = ?, categoryid = ?, ");
        sql.append("createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
        update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
                updateNew.getContent(), updateNew.getCategoryid(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
                updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM news WHERE id =?";
        update(sql, id);
    }

    @Override
    public List<NewModel> findAll(Integer offset, Integer limit) {
        String sql = "SELECT * FROM news LIMIT ?, ?";
        return query(sql, new NewMapper(), offset, limit);
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM news";
        return count(sql);
    }

    @Override
    public NewModel findOne(Long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewModel> news = query(sql, new NewMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public List<NewModel> findByCategoryId(Long categoryid) {
        String sql = "SELECT * FROM news WHERE categoryid=?";
         return query(sql, new NewMapper(), categoryid);
      }

    @Override
    public Long save(NewModel newModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
        sql.append(" thumbnail, shortDescription, categoryid, createddate, createdby)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), newModel.getTitle(), newModel.getContent(),
                newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCategoryid(),
                newModel.getCreatedDate(), newModel.getCreatedBy());
    }
}

