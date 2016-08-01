package com.myorg.gwt.main.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.myorg.gwt.common.shared.UserDTO;

public interface MainView extends IsWidget {
    void setPresenter(IMainPresenter presenter);
    void initHomePage(UserDTO result);


    interface IMainPresenter {
    }
}
