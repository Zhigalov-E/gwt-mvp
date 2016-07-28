package com.myorg.gwt.login.client.ioc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.myorg.gwt.login.client.ClientFactory;
import com.myorg.gwt.login.client.ClientFactoryImpl;
import com.myorg.gwt.login.client.i18n.AppMessages;
import com.myorg.gwt.login.client.mvp.activity.LoginActivity;
import com.myorg.gwt.login.client.mvp.activity.MainActivity;
import com.myorg.gwt.login.client.mvp.place.InjectablePlaceController;
import com.myorg.gwt.login.client.mvp.view.ILoginView;
import com.myorg.gwt.login.client.mvp.view.IMainView;
import com.myorg.gwt.login.client.mvp.view.css.LoginResources;
import com.myorg.gwt.login.client.mvp.view.login.LoginView;
import com.myorg.gwt.login.client.mvp.view.main.MainView;


public class ApplicationGinModule extends AbstractGinModule {


    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(ILoginView.class).to(LoginView.class).in(Singleton.class);
        bind(IMainView.class).to(MainView.class).in(Singleton.class);

        bind(PlaceController.class).to(InjectablePlaceController.class).in(Singleton.class);

        bind(ClientFactory.class).to(ClientFactoryImpl.class).in(Singleton.class);

        bind(ILoginView.ILoginPresenter.class).to(LoginActivity.class).in(Singleton.class);
        bind(IMainView.IMainPresenter.class).to(MainActivity.class).in(Singleton.class);

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
