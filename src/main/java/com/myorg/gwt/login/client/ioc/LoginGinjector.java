package com.myorg.gwt.login.client.ioc;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.myorg.gwt.login.client.ClientFactory;

@GinModules(LoginGinModule.class)
public interface LoginGinjector extends Ginjector {

    ClientFactory getClientFactory();

}
