package com.myorg.gwt.login.client.ioc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.login.client.Initializer;
import com.myorg.gwt.login.client.mvp.presenter.LoginPresenter;
import com.myorg.gwt.login.client.mvp.view.LoginView;
import com.myorg.gwt.login.client.mvp.view.css.LoginResources;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;
import com.myorg.gwt.main.client.mvp.view.MainView;

@GinModules(LoginGinModule.class)
public interface LoginGinjector extends Ginjector {
    public static final LoginGinjector INSTANCE = GWT.create(LoginGinjector.class);

    Initializer getInitializer();

    EventBus getEventBus();
    PlaceController getPlaceController();
    AppMessages getAppMessages();
    LoginResources getLoginResources();
    LoginView getLoginView();
    MainView getMainView();
    LoginPresenter getLoginPresenter();
    MainPresenter getMainPresenter();

}
