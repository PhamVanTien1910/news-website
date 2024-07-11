package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.model.NewModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewModel>{
    @Override
    public NewModel mapRow(ResultSet resultSet) {
        NewModel newModel = new NewModel() ;
        try {
            newModel.setId(resultSet.getLong("id"));
            newModel.setTitle(resultSet.getString("title"));
            newModel.setShortescription(resultSet.getString("shortdescription"));
            newModel.setThumbnail(resultSet.getString("thumbnail"));
            newModel.setContent(resultSet.getString("content"));
            newModel.setCategoryid(resultSet.getLong("categoryid"));
            newModel.setCreatedBy(resultSet.getString("createdby"));
            newModel.setCreatedDate(resultSet.getTimestamp("createddate"));
            if (resultSet.getTimestamp("modifieddate") != null) {
                newModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            }
            if (resultSet.getString("modifiedby") != null) {
                newModel.setModifiedBy(resultSet.getString("modifiedby"));
            }
            return newModel;
        } catch (SQLException e) {
            return null;
        }

    }
}
