package com.myorg.gwt.file.client.mvp.presenter;


import com.myorg.gwt.file.client.mvp.view.FileView;

public interface FilePresenter {
    void init(FileView view);

    void clearData();

    boolean isFileChoosen(String filename);

    void onGetResponse(String srvResponse);
}
