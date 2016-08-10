package com.myorg.gwt.application.client.ioc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.application.client.ApplicationLauncher;
import com.myorg.gwt.login.client.mvp.presenter.LoginPresenter;
import com.myorg.gwt.login.client.mvp.view.LoginView;
import com.myorg.gwt.login.client.mvp.view.css.LoginResources;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;
import com.myorg.gwt.main.client.mvp.view.MainView;
import com.myorg.gwt.main.client.mvp.view.css.MainResources;

@GinModules(AppGinModule.class)
public interface AppGinjector extends Ginjector {
    AppGinjector INSTANCE = GWT.create(AppGinjector.class);

    ApplicationLauncher getInitializer();

    EventBus getEventBus();
    PlaceController getPlaceController();
    AppMessages getAppMessages();
    LoginResources getLoginResources();
    MainResources getMainResources();
    LoginView getLoginView();
    MainView getMainView();
    LoginPresenter getLoginPresenter();
    MainPresenter getMainPresenter();

}