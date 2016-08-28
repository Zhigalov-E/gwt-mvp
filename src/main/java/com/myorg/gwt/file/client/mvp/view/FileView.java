package com.myorg.gwt.file.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.myorg.gwt.file.client.mvp.presenter.FilePresenter;

public interface FileView extends IsWidget, FileViewData, FileViewMessage {
    void setPresenter(FilePresenter presenter);
}
