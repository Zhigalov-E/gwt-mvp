package com.myorg.gwt.login.client.ioc;


import com.google.inject.Singleton;
import com.myorg.gwt.common.client.ioc.ApplicationGinModule;

import com.myorg.gwt.login.client.mvp.activity.LoginActivity;
import com.myorg.gwt.login.client.mvp.view.login.LoginViewImpl;
import com.myorg.gwt.main.client.mvp.activity.MainActivity;

import com.myorg.gwt.login.client.mvp.view.LoginView;
import com.myorg.gwt.main.client.mvp.view.MainView;
import com.myorg.gwt.main.client.mvp.view.main.MainViewImpl;


public class LoginGinModule extends ApplicationGinModule {

    @Override
    protected void configure() {
        super.configure();
        bind(LoginView.class).to(LoginViewImpl.class).in(Singleton.class);
        bind(MainView.class).to(MainViewImpl.class).in(Singleton.class);
        bind(LoginView.ILoginPresenter.class).to(LoginActivity.class).in(Singleton.class);
        bind(MainView.IMainPresenter.class).to(MainActivity.class).in(Singleton.class);
    }

}
