package com.myorg.gwt.login.client;

import com.google.gwt.core.client.EntryPoint;
import com.myorg.gwt.login.client.ioc.LoginGinjector;


public class LoginEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Initializer initializer = LoginGinjector.INSTANCE.getInitializer();
        initializer.initApp();
    }

}
