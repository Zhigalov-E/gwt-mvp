package com.myorg.gwt.file.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.myorg.gwt.file.client.mvp.presenter.FilePresenter;
import com.myorg.gwt.file.client.widget.IClient;

import java.util.List;

public interface FileView extends IsWidget {
    void setPresenter(FilePresenter presenter);
    //TODO: Extract methods to new interface
    void clearData();
    void showData(List<IClient> clients);
    //TODO: Extract methods --//---
    void setWarnMessage(String value);
    void clearWarnMessage();
}
