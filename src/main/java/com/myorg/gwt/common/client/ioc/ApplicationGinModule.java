package com.myorg.gwt.common.client.ioc;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.common.client.mvp.DemoActivityMapper;
import com.myorg.gwt.common.client.mvp.place.InjectablePlaceController;
import com.myorg.gwt.login.client.mvp.view.css.LoginResources;


public class ApplicationGinModule extends AbstractGinModule {


    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(PlaceController.class).to(InjectablePlaceController.class).in(Singleton.class);
        bind(ActivityMapper.class).to(DemoActivityMapper.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    AppMessages createAppMessages() {
        return GWT.create(AppMessages.class);
    }

    @Provides
    @Singleton
    LoginResources createLoginResources() {
        LoginResources loginResources = GWT.create(LoginResources.class);
        loginResources.style().ensureInjected();
        return loginResources;
    }
}
