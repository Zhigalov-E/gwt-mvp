package com.myorg.gwt.application.client.ioc;


import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.myorg.gwt.application.client.mvp.DemoActivityMapper;
import com.myorg.gwt.common.client.ioc.ApplicationGinModule;
import com.myorg.gwt.file.client.mvp.presenter.FilePresenter;
import com.myorg.gwt.file.client.mvp.presenter.FilePresenterImpl;
import com.myorg.gwt.file.client.mvp.view.FileView;
import com.myorg.gwt.file.client.mvp.view.css.FileResources;
import com.myorg.gwt.file.client.mvp.view.file.FileViewImpl;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenterImpl;
import com.myorg.gwt.main.client.mvp.view.MainView;
import com.myorg.gwt.main.client.mvp.view.css.MainResources;
import com.myorg.gwt.main.client.mvp.view.main.MainViewImpl;


public class AppGinModule extends ApplicationGinModule {

    @Override
    protected void configure() {
        super.configure();
        bind(ActivityMapper.class).to(DemoActivityMapper.class).in(Singleton.class);
        bind(MainView.class).to(MainViewImpl.class).in(Singleton.class);
        bind(FileView.class).to(FileViewImpl.class).in(Singleton.class);
        bind(MainPresenter.class).to(MainPresenterImpl.class).in(Singleton.class);
        bind(FilePresenter.class).to(FilePresenterImpl.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    FileResources createFileResources() {
        FileResources fileResources = GWT.create(FileResources.class);
        fileResources.style().ensureInjected();
        return fileResources;
    }


    @Provides
    @Singleton
    MainResources createMainResources() {
        MainResources mainResources = GWT.create(MainResources.class);
        mainResources.style().ensureInjected();
        return mainResources;
    }

}