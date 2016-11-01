package com.myorg.gwt.common.server.locators;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.myorg.gwt.common.server.entity.User;

public class UserLocator extends Locator<User, Long> {
    @Override
    public User create(Class<? extends User> aClass) {
        return new User();
    }

    @Override
    public User find(Class<? extends User> aClass, Long aLong) {
        return null;
    }

    @Override
    public Class<User> getDomainType() {
        return User.class;
    }

    @Override
    public Long getId(User user) {
        return user.getId().longValue();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(User user) {
        return user.getVersion();
    }
}
