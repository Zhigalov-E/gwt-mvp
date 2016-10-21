package com.myorg.gwt.common.server.dao;

import com.myorg.gwt.common.server.entity.User;

import java.util.List;

public interface UserDao {
    User getUserByLogin(String login);
    List<User> getUsersSortedByBirthday();
}
