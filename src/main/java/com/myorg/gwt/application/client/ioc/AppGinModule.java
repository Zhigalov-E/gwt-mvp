package com.myorg.gwt.application.client.ioc;


import com.google.gwt.core.client.GWT;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.myorg.gwt.common.client.ioc.ApplicationGinModule;
import com.myorg.gwt.login.client.mvp.presenter.LoginPresenter;
import com.myorg.gwt.login.client.mvp.presenter.LoginPresenterImpl;
import com.myorg.gwt.login.client.mvp.view.LoginView;
import com.myorg.gwt.login.client.mvp.view.css.LoginResources;
import com.myorg.gwt.login.client.mvp.view.login.LoginViewImpl;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenterImpl;
import com.myorg.gwt.main.client.mvp.view.MainView;
import com.myorg.gwt.main.client.mvp.view.main.MainViewImpl;


public class AppGinModule extends ApplicationGinModule {


    @Override
    protected void configure() {
        super.configure();
        bind(LoginView.class).to(LoginViewImpl.class).in(Singleton.class);
        bind(MainView.class).to(MainViewImpl.class).in(Singleton.class);
        bind(LoginPresenter.class).to(LoginPresenterImpl.class).in(Singleton.class);
        bind(MainPresenter.class).to(MainPresenterImpl.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    LoginResources createLoginResources() {
        LoginResources loginResources = GWT.create(LoginResources.class);
        loginResources.style().ensureInjected();
        return loginResources;
    }

}