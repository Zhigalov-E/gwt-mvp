package com.myorg.gwt.login.server.dao;

import com.myorg.gwt.login.server.entity.User;

public interface UserDAO {
    User getUserByLogin(String login);
}
