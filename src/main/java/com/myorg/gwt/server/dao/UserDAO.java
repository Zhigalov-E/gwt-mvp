package com.myorg.gwt.server.dao;

import com.myorg.gwt.server.entity.User;

public interface UserDAO {
    User getUserByLogin(String login);
}
