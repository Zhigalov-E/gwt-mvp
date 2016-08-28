package com.myorg.gwt.file.client.mvp.view;

import com.myorg.gwt.file.client.widget.IClient;

import java.util.List;

public interface FileViewData {
    void clearData();
    void showData(List<IClient> clients);
}
