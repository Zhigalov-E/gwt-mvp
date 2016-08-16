package com.myorg.gwt.main.client.mvp.presenter;

import com.myorg.gwt.main.client.mvp.view.MainView;

public interface MainPresenter {
    void init(MainView view);

    void clearData();

    boolean isFileChoosen(String filename);

    void onGetResponse(String srvResponse);
}
