package com.myorg.gwt.application.client.ioc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.application.client.ApplicationLauncher;
import com.myorg.gwt.file.client.i18n.FileConstants;
import com.myorg.gwt.file.client.mvp.presenter.FilePresenter;
import com.myorg.gwt.file.client.mvp.view.FileView;
import com.myorg.gwt.file.client.mvp.view.css.FileResources;
import com.myorg.gwt.login.client.mvp.presenter.LoginPresenter;
import com.myorg.gwt.login.client.mvp.view.LoginView;
import com.myorg.gwt.login.client.mvp.view.css.LoginResources;
import com.myorg.gwt.file.client.i18n.FileUploadMessages;
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
    FileUploadMessages getFileMessages();
    FileConstants getFileConstants();
    LoginResources getLoginResources();
    MainResources getMainResources();
    FileResources getFileResources();
    LoginView getLoginView();
    MainView getMainView();
    FileView getFileView();
    LoginPresenter getLoginPresenter();
    MainPresenter getMainPresenter();
    FilePresenter getFilePresenter();
}