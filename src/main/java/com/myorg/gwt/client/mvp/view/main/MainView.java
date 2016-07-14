package com.myorg.gwt.client.mvp.view.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.myorg.gwt.client.i18n.AppMessages;
import com.myorg.gwt.client.mvp.view.IMainView;
import com.myorg.gwt.client.rpc.LoginRpcService;
import com.myorg.gwt.client.utils.TimeMessager;
import com.myorg.gwt.shared.UserDTO;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainView extends Composite implements IMainView {
    @UiTemplate("MainView.ui.xml")
    interface MainViewUiBinder extends UiBinder<Widget, MainView> {
    }
    private static final Logger LOGGER = Logger.getLogger(MainView.class.getName());
    private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

    private IMainPresenter presenter;

    @UiField(provided = true)
    final AppMessages i18n;
    @UiField
    Anchor logOut;
    @UiField
    Label userGreeting;

    public MainView() {
        this.i18n = GWT.create(AppMessages.class);
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("logOut")
    public void onClick(ClickEvent clickEvent) {
        LoginRpcService.Util.getInstance().logout(new AsyncCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                LOGGER.log(Level.SEVERE, "Error with logout operation.");
                Window.alert(getI18n().logoutProblem());
            }

            @Override
            public void onSuccess(Object o) {
                LOGGER.log(Level.INFO, "Logout DONE.");
                goToLogin();
            }
        });
    }

    public void initHomePage(UserDTO userDTO) {
        String greeting = TimeMessager.getInstance().getMessageResouse(new Date());
        String userGreeting = getI18n().userGreeting(greeting, userDTO.getName());
        this.getUserGreeting().setText(userGreeting);
        // Window.Location.assign("#main:");
    }

    public void setPresenter(IMainPresenter presenter) {
        this.presenter = presenter;
    }

    public void goToLogin() {
        Window.Location.assign("#login:");
    }


    public AppMessages getI18n() {
        return i18n;
    }

    public Anchor getLogOut() {
        return logOut;
    }

    public void setLogOut(Anchor logOut) {
        this.logOut = logOut;
    }

    public Label getUserGreeting() {
        return userGreeting;
    }

    public void setUserGreeting(Label userGreeting) {
        this.userGreeting = userGreeting;
    }
}
