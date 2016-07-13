package com.myorg.gwt.client.mvp.activity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.myorg.gwt.client.AppConstants;
import com.myorg.gwt.client.ClientFactory;
import com.myorg.gwt.client.MvpInActionEntryPoint;
import com.myorg.gwt.client.i18n.AppMessages;
import com.myorg.gwt.client.mvp.view.ILoginView;
import com.myorg.gwt.client.mvp.view.main.MainView;
import com.myorg.gwt.client.rpc.LoginRpcService;
import com.myorg.gwt.client.utils.TimeMessager;
import com.myorg.gwt.shared.UserDTO;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginActivity extends AbstractMainActivity implements ILoginView.ILoginPresenter {
    private static final Logger LOGGER = Logger.getLogger(LoginActivity.class.getName());

    private ClientFactory clientFactory;
    private final AppMessages i18n = GWT.create(AppMessages.class);
    public LoginActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        applyCurrentLinkStyle(AppConstants.LOGIN_LINK_ID);

        final ILoginView view = clientFactory.getLoginView();
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
                    showHomePage(result);
                    //set session cookie for 1 day expiry.
                    String sessionID = result.getSessionId();
                    final long DURATION = 1000 * 60 * 60 * 24 * 1;
                    Date expires = new Date(System.currentTimeMillis() + DURATION);
                    Cookies.setCookie("sid", sessionID, expires, null, "/", false);
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

    public void showHomePage(UserDTO userDTO) {
        String greeting = TimeMessager.getInstance().getMessageResouse(new Date());
        String userGreeting = getI18n().userGreeting(greeting, userDTO.getName());
        MainView mainView = (MainView)clientFactory.getMainView();
        mainView.getUserGreeting().setText(userGreeting);

        Window.Location.assign("#main:");
    }

    public AppMessages getI18n() {
        return i18n;
    }
}
