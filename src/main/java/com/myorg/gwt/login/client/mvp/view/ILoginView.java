package com.myorg.gwt.login.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface ILoginView extends IsWidget {

    void setPresenter(ILoginPresenter presenter);


    interface ILoginPresenter {
        void sendToServer(String login, String password);

        void checkWithServerIfSessionIdIsStillLegal();
    }
}
