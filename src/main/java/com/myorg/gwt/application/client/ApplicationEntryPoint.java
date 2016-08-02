package com.myorg.gwt.application.client;

import com.google.gwt.core.client.EntryPoint;
import com.myorg.gwt.application.client.ioc.AppGinjector;


public class ApplicationEntryPoint implements EntryPoint {
    public void onModuleLoad() {
        ApplicationLauncher appLauncher = AppGinjector.INSTANCE.getInitializer();
        appLauncher.launch();
    }
}
