package com.myorg.gwt.file.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.myorg.gwt.file.client.mvp.presenter.FilePresenter;

public interface FileView extends IsWidget {
    void setPresenter(FilePresenter presenter);
    void clearData();
    void showData(String text);
}
