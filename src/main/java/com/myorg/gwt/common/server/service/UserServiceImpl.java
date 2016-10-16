package com.myorg.gwt.common.server.service;

import com.myorg.gwt.common.server.dao.UserDao;
import com.myorg.gwt.common.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public List<User> getUsersSortedByBirthday() {
        return userDao.getUsersSortedByBirthday();
    }
}
