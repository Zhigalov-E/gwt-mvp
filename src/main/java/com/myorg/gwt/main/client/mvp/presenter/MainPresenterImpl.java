package com.myorg.gwt.main.client.mvp.presenter;


import com.myorg.gwt.main.client.mvp.view.MainView;

public class MainPresenterImpl implements  MainPresenter {

    private MainView view;

    @Override
    public void init(MainView view) {
        this.view = view;
        view.setPresenter(this);
    }
}
