package com.myorg.gwt.application.client.ioc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.myorg.gwt.application.client.ApplicationLauncher;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.file.client.i18n.FileConstants;
import com.myorg.gwt.file.client.i18n.FileUploadMessages;
import com.myorg.gwt.file.client.mvp.presenter.FilePresenter;
import com.myorg.gwt.file.client.mvp.view.FileView;
import com.myorg.gwt.file.client.mvp.view.css.FileResources;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;
import com.myorg.gwt.main.client.mvp.view.MainView;
import com.myorg.gwt.main.client.mvp.view.css.MainResources;
import com.myorg.gwt.users.client.mvp.presenter.UsersPresenter;
import com.myorg.gwt.users.client.mvp.view.UsersView;
import com.myorg.gwt.users.client.mvp.view.css.UsersResources;

@GinModules(AppGinModule.class)
public interface AppGinjector extends Ginjector {
    AppGinjector INSTANCE = GWT.create(AppGinjector.class);

    ApplicationLauncher getInitializer();

    EventBus getEventBus();
    PlaceController getPlaceController();
    AppMessages getAppMessages();
    FileUploadMessages getFileMessages();
    FileConstants getFileConstants();
    MainResources getMainResources();
    FileResources getFileResources();
    UsersResources getUsersResources();
    MainView getMainView();
    FileView getFileView();
    UsersView getUsersView();
    MainPresenter getMainPresenter();
    FilePresenter getFilePresenter();
    UsersPresenter getUsersPresenter();
}