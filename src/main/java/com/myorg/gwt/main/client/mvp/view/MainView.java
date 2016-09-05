package com.myorg.gwt.main.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;

public interface MainView extends IsWidget {
    void setPresenter(MainPresenter presenter);
    void setUserGreetingText(String userGreetingText);
}
