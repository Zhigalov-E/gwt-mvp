package com.myorg.gwt.login.client.mvp.presenter;


import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.common.client.rpc.LoginRpcService;
import com.myorg.gwt.common.shared.UserDTO;
import com.myorg.gwt.login.client.mvp.activity.LoginActivity;
import com.myorg.gwt.login.client.mvp.view.LoginView;
import com.myorg.gwt.main.client.mvp.place.MainPlace;
import com.myorg.gwt.main.client.mvp.view.MainView;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPresenterImpl implements LoginPresenter {

    public static final long DURATION = 1000 * 60 * 60 * 24 * 1;
    private static final Logger LOGGER = Logger.getLogger(LoginPresenterImpl.class.getName());
    public static final String SID = "sid";

    private LoginView view;

    @Inject
    private AppMessages i18n;

    @Inject
    private MainView mainView;

    @Inject
    PlaceController placeController;


    @Override
    public void init(LoginView view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void sendToServer(String login, String password) {
        LoginRpcService.Util.getInstance().loginServer(login, password, new AsyncCallback<UserDTO>() {
            @Override
            public void onSuccess(UserDTO result) {
                if (result.getLoggedIn()) {
                    LOGGER.log(Level.INFO, "Success login operation.");
                    // load the home app page
                    initAndGoToUserPage(result);
                    //set session cookie for 1 day expiry.
                    String sessionID = result.getSessionId();
                    Date expires = new Date(System.currentTimeMillis() + DURATION);
                    Cookies.setCookie(SID, sessionID, expires, null, "/", false);
                } else {
                    LOGGER.log(Level.WARNING, "Access Denied. Wrong login or password.");
                    Window.alert(getI18n().accessDenied());
                }
            }

            @Override
            public void onFailure(Throwable caught) {
                LOGGER.log(Level.SEVERE, "Error with login operation.", caught);
                Window.alert(getI18n().accessDenied());
            }
        });
    }

    @Override
    public void checkWithServerIfSessionIdIsStillLegal() {
        LoginRpcService.Util.getInstance().loginFromSessionServer(new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                LOGGER.log(Level.SEVERE, "Error with check login session.", caught);
            }

            @Override
            public void onSuccess(UserDTO result) {
                if (result != null && result.getLoggedIn()) {
                    LOGGER.log(Level.INFO, "User session is still valid.");
                    initAndGoToUserPage(result);
                } else {
                    LOGGER.log(Level.INFO, "User session has expired.");
                }
            }
        });
    }

    private void initAndGoToUserPage(UserDTO result) {
        mainView.initHomePage(result);
        placeController.goTo(new MainPlace());
    }

    public AppMessages getI18n() {
        return i18n;
    }
}
