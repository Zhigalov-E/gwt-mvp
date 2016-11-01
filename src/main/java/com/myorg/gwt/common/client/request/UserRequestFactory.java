package com.myorg.gwt.common.client.request;


import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface UserRequestFactory extends RequestFactory {
    UserRequest getUserRequest();
}
