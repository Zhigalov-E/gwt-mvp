package com.myorg.gwt.common.server.dao;

import com.myorg.gwt.common.server.entity.User;
import org.apache.log4j.Logger;


public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    public User getUserByLogin(String login) {
        throw new UnsupportedOperationException();
    }
}