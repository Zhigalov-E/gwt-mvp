package com.myorg.gwt.client.ioc;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.myorg.gwt.client.ClientFactory;

@GinModules(ApplicationGinModule.class)
public interface ApplicationGinjector extends Ginjector {

    ClientFactory getClientFactory();

}
