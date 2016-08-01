package com.myorg.gwt.login.client.mvp.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myorg.gwt.login.client.ClientFactory;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.login.client.mvp.presenter.LoginPresenter;
import com.myorg.gwt.main.client.mvp.place.MainPlace;
import com.myorg.gwt.login.client.mvp.view.LoginView;
import com.myorg.gwt.common.client.rpc.LoginRpcService;
import com.myorg.gwt.common.shared.UserDTO;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginActivity extends AbstractActivity implements LoginPresenter {
    public static final long DURATION = 1000 * 60 * 60 * 24 * 1;
    private static final Logger LOGGER = Logger.getLogger(LoginActivity.class.getName());
    public static final String SID = "sid";

    private ClientFactory clientFactory;
    private final AppMessages i18n = GWT.create(AppMessages.class);

    @Inject
    public LoginActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        final LoginView view = clientFactory.getLoginView();
        view.setPresenter(this);
        container.setWidget(view.asWidget());
    }

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
        clientFactory.getMainView().initHomePage(result);
        clientFactory.getPlaceController().goTo(new MainPlace());
    }

    public AppMessages getI18n() {
        return i18n;
    }
}
