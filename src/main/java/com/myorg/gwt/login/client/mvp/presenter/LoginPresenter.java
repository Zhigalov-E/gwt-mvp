package com.myorg.gwt.login.client.mvp.presenter;


import com.myorg.gwt.login.client.mvp.view.LoginView;

public interface LoginPresenter {
    void sendToServer(String login, String password);

    void checkWithServerIfSessionIdIsStillLegal();

    void init(LoginView view);
}
