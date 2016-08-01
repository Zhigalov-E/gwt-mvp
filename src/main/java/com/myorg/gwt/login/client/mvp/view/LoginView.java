package com.myorg.gwt.login.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.myorg.gwt.login.client.mvp.presenter.LoginPresenter;


public interface LoginView extends IsWidget {

    void setPresenter(LoginPresenter presenter);

}
