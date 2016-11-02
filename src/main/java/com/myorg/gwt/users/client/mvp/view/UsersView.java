package com.myorg.gwt.users.client.mvp.view;


import com.google.gwt.user.client.ui.IsWidget;
import com.myorg.gwt.users.client.mvp.presenter.UsersPresenter;

public interface UsersView extends IsWidget {
    void setPresenter(UsersPresenter presenter);
}
