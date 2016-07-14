package com.myorg.gwt.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.myorg.gwt.shared.UserDTO;

public interface IMainView extends IsWidget {
    void setPresenter(IMainPresenter presenter);
    void initHomePage(UserDTO result);


    interface IMainPresenter {
    }
}
