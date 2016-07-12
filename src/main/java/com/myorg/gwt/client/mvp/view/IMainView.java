package com.myorg.gwt.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface IMainView extends IsWidget {
    public void setPresenter(IMainPresenter presenter);

    public interface IMainPresenter {
    }
}
