package com.myorg.gwt.common.server.dao;

import com.myorg.gwt.common.server.entity.User;

public interface UserDAO {
    User getUserByLogin(String login);
}
