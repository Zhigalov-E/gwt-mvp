package com.myorg.gwt.file.client.mvp.presenter;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.myorg.gwt.file.client.i18n.FileUploadMessages;
import com.myorg.gwt.file.client.mvp.view.FileView;

public class FilePresenterImpl implements FilePresenter {

    private FileView view;

    @Inject
    private FileUploadMessages fileUploadMessages;

    @Override
    public void init(FileView view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void clearData() {
        view.clearData();
    }

    @Override
    public boolean isFileChoosen(String filename) {
        boolean result = true;
        if ("".equals(filename)) {
            Window.alert(fileUploadMessages.fileNotSelected());
            result = false;
        }
        return  result;
    }

    @Override
    public void onGetResponse(String srvResponse) {
        if(srvResponse == null || srvResponse.equals("")) {
            Window.alert(fileUploadMessages.fileNotValid());
        } else {
            view.showData(srvResponse);
        }
    }
}
