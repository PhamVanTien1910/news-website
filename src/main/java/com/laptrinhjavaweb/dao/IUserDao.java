package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;


public interface IUserDao extends GenericDao<UserModel> {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
