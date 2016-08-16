package com.myorg.gwt.main.client.mvp.view.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.common.client.rpc.LoginRpcService;
import com.myorg.gwt.common.client.utils.TimeMessager;
import com.myorg.gwt.common.shared.UserDTO;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;
import com.myorg.gwt.main.client.mvp.view.css.MainResources;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainViewImpl extends Composite implements com.myorg.gwt.main.client.mvp.view.MainView {
    @UiTemplate("MainViewImpl.ui.xml")
    interface MainViewUiBinder extends UiBinder<Widget, MainViewImpl> {
    }
    private static final Logger LOGGER = Logger.getLogger(MainViewImpl.class.getName());
    private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

    private MainPresenter presenter;

    @UiField(provided = true)
    final AppMessages i18n;

    @UiField(provided = true)
    final MainResources css;

    @UiField
    Anchor logOut;

    @UiField
    Label userGreeting;

    @UiField
    FormPanel form;

    @UiField
    FileUpload uploadField;

    @UiField
    SubmitButton uploadButton;

    @UiField
    Button clearButton;

    @UiField
    TextArea clientData;

    @Inject
    public MainViewImpl(final AppMessages i18n, final MainResources css) {
        this.css = css;
        this.i18n = i18n;
        initWidget(uiBinder.createAndBindUi(this));
        initAcceptFormat();
    }

    @UiHandler("logOut")
    public void onClickLogOut(ClickEvent clickEvent) {
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

    @UiHandler("clearButton")
    public void onClickClearButton(ClickEvent clickEvent) {
        presenter.clearData();
    }

    @UiHandler("form")
    public void onSubmitForm(FormPanel.SubmitEvent event) {
        if(!presenter.isFileChoosen(uploadField.getFilename())) {
            event.cancel();
        }
    }

    @UiHandler("form")
    public void onCompleteForm(FormPanel.SubmitCompleteEvent event) {
        String srvResponse = event.getResults();
        presenter.onGetResponse(srvResponse);
    }

    public void initHomePage(UserDTO userDTO) {
        String greeting = TimeMessager.getInstance().getMessageResouse(new Date());
        String userGreeting = getI18n().userGreeting(greeting, userDTO.getName());
        this.getUserGreeting().setText(userGreeting);
    }

    private void initAcceptFormat() {
        uploadField.getElement().setAttribute("accept", ".csv");
    }

    @Override
    public void clearData() {
        clientData.setText("");
    }

    @Override
    public void showData(String text) {
        clientData.setText(text);
    }

    public void setPresenter(MainPresenter presenter) {
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
