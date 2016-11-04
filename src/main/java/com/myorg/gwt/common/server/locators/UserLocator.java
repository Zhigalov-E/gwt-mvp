package com.myorg.gwt.common.server.locators;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.myorg.gwt.common.server.entity.User;

public class UserLocator extends Locator<User, Integer> {
    @Override
    public User create(Class<? extends User> aClass) {
        return new User();
    }

    @Override
    public User find(Class<? extends User> aClass, Integer aInteger) {
        return null;
    }

    @Override
    public Class<User> getDomainType() {
        return User.class;
    }

    @Override
    public Integer getId(User user) {
        return user.getId();
    }

    @Override
    public Class<Integer> getIdType() {
        return Integer.class;
    }

    @Override
    public Integer getVersion(User user) {
        return user.getVersion();
    }
}
