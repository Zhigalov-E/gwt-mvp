package com.myorg.gwt.main.client.mvp.presenter;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.common.client.rpc.LoginRpcService;
import com.myorg.gwt.common.client.rpc.LoginRpcServiceAsync;
import com.myorg.gwt.common.client.utils.TimeMessager;
import com.myorg.gwt.common.shared.UserDTO;
import com.myorg.gwt.main.client.mvp.view.MainView;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainPresenterImpl implements  MainPresenter {

    private Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());
    private MainView view;

    @Inject
    AppMessages i18n;
    @Inject
    LoginRpcServiceAsync loginRpcService;

    @Override
    public void init(MainView view) {
        this.view = view;
        view.setPresenter(this);
        getLoginUser();
    }

    public void getLoginUser() {
        loginRpcService.loginFromSessionServer(new AsyncCallback<UserDTO>() {
            @Override
            public void onSuccess(UserDTO result) {
                    LOGGER.log(Level.INFO, "Success login operation.");
                    // load the home app page
                    initGreeting(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                LOGGER.log(Level.SEVERE, "Error with login operation.", caught);
            }
        });
    }

    private void initGreeting(UserDTO result) {
        String greeting = TimeMessager.getInstance().getMessageResouse(new Date());
        String userGreeting = getI18n().userGreeting(greeting, result.getName());
        view.setUserGreetingText(userGreeting);
    }

    public AppMessages getI18n() {
        return i18n;
    }

}
