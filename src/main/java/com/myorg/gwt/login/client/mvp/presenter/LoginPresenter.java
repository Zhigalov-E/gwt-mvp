package com.myorg.gwt.login.client.mvp.presenter;


public interface LoginPresenter {
    void sendToServer(String login, String password);

    void checkWithServerIfSessionIdIsStillLegal();
}
