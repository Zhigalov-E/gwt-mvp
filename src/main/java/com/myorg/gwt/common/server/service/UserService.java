package com.myorg.gwt.common.server.service;


import com.myorg.gwt.common.server.entity.User;

import java.util.List;

public interface UserService {
    User getUserByLogin(String login);
    List<User> getUsersSortedByBirthday();
}
