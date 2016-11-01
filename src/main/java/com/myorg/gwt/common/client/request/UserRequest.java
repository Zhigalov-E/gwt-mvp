package com.myorg.gwt.common.client.request;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.myorg.gwt.common.client.proxy.UserProxy;
import com.myorg.gwt.common.server.locators.WebApplicationContextServiceLocator;
import com.myorg.gwt.common.server.service.UserService;

import java.util.List;

@Service(value = UserService.class, locator = WebApplicationContextServiceLocator.class)
public interface UserRequest extends RequestContext {
    Request<List<UserProxy>> getUsersSortedByBirthday();
}
