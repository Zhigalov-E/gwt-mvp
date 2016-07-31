package com.myorg.gwt.login.client.ioc;


import com.google.inject.Singleton;
import com.myorg.gwt.common.client.ioc.ApplicationGinModule;

import com.myorg.gwt.login.client.mvp.activity.LoginActivity;
import com.myorg.gwt.main.client.mvp.activity.MainActivity;

import com.myorg.gwt.login.client.mvp.view.ILoginView;
import com.myorg.gwt.main.client.mvp.view.IMainView;
import com.myorg.gwt.login.client.mvp.view.login.LoginView;
import com.myorg.gwt.main.client.mvp.view.main.MainView;


public class LoginGinModule extends ApplicationGinModule {

    @Override
    protected void configure() {
        super.configure();
        bind(ILoginView.class).to(LoginView.class).in(Singleton.class);
        bind(IMainView.class).to(MainView.class).in(Singleton.class);
        bind(ILoginView.ILoginPresenter.class).to(LoginActivity.class).in(Singleton.class);
        bind(IMainView.IMainPresenter.class).to(MainActivity.class).in(Singleton.class);
    }

}
