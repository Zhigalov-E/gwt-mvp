package com.myorg.gwt.common.client.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.myorg.gwt.common.server.entity.User;
import com.myorg.gwt.common.server.locators.UserLocator;

import java.util.Date;

@ProxyFor(value = User.class, locator = UserLocator.class)
public interface UserProxy extends EntityProxy {
    Integer getId();
    String getFirstName();
    String getLastName();
    Date getBirthday();
	String getLogin();
    String getEmail();
}
