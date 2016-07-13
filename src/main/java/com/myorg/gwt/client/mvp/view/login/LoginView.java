package com.myorg.gwt.client.mvp.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.myorg.gwt.client.i18n.AppMessages;
import com.myorg.gwt.client.mvp.view.ILoginView;
import com.myorg.gwt.client.mvp.view.css.LoginResources;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginView extends Composite implements ILoginView {
    @UiTemplate("LoginView.ui.xml")
    interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
    }
    private static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());
    private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);
    private static final int MIN_PASSWORD_LEN = 4;
    private static final int MIN_LOGIN_LEN = 4;

    private ILoginPresenter presenter;

    private Boolean tooShort = true;
    @UiField(provided = true)
    final LoginResources res;
    @UiField(provided = true)
    final AppMessages i18n;
    @UiField
    TextBox loginBox;
    @UiField
    TextBox passwordBox;
    @UiField
    Label completionLabel1;
    @UiField
    Label completionLabel2;
    @UiField
    Button buttonSubmit;

    public LoginView() {
        this.res = GWT.create(LoginResources.class);
        this.i18n = GWT.create(AppMessages.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(ILoginPresenter presenter) {
        this.presenter = presenter;
    }

    @UiHandler("loginBox")
    public void onValueChangeLoginBox(ValueChangeEvent<String> valueChangeEvent) {
        if (!checkLoginLength(valueChangeEvent.getValue())) {
            completionLabel1.setText(i18n.login2Short("" + MIN_LOGIN_LEN));
            tooShort = true;
        } else {
            tooShort = false;
            completionLabel1.setText("");
        }
    }

    @UiHandler("passwordBox")
    public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
        if (!checkPasswordLength(valueChangeEvent.getValue())) {
            tooShort = true;
            completionLabel2.setText(i18n.password2Short("" + MIN_PASSWORD_LEN));
        } else {
            tooShort = false;
            completionLabel2.setText("");
        }
    }

    @UiHandler("buttonSubmit")
    public void onClick(ClickEvent clickEvent) {
        if (getTooShort()) {
            LOGGER.log(Level.WARNING, "Login or password too short.");
            Window.alert(getI18n().loginOrPwd2Short());
        } else {
            LOGGER.log(Level.INFO, "Send user auth data to server.");
            presenter.sendToServer(getLoginBox().getValue(), getPasswordBox().getValue());
        }
    }

    /*@UiHandler("buttonSubmit")
    void doClickSubmit(ClickEvent event) {

        Window.Location.assign("#main:");
    }*/

    @Override
    protected void onUnload() {
        this.loginBox.setText("");
        this.passwordBox.setText("");
    }

    private boolean checkLoginLength(String login) {
        boolean result = false;
        if (login.length() >= MIN_LOGIN_LEN) {
            result = true;
        }
        return result;
    }

    private boolean checkPasswordLength(String pwd) {
        boolean result = false;
        if (pwd.length() >= MIN_PASSWORD_LEN) {
            result = true;
        }
        return result;
    }


    public LoginResources getRes() {
        return res;
    }

    public AppMessages getI18n() {
        return i18n;
    }

    public Boolean getTooShort() {
        return tooShort;
    }

    public void setTooShort(Boolean tooShort) {
        this.tooShort = tooShort;
    }

    public TextBox getLoginBox() {
        return loginBox;
    }

    public void setLoginBox(TextBox loginBox) {
        this.loginBox = loginBox;
    }

    public TextBox getPasswordBox() {
        return passwordBox;
    }

    public void setPasswordBox(TextBox passwordBox) {
        this.passwordBox = passwordBox;
    }

    public Label getCompletionLabel1() {
        return completionLabel1;
    }

    public void setCompletionLabel1(Label completionLabel1) {
        this.completionLabel1 = completionLabel1;
    }

    public Label getCompletionLabel2() {
        return completionLabel2;
    }

    public void setCompletionLabel2(Label completionLabel2) {
        this.completionLabel2 = completionLabel2;
    }

    public Button getButtonSubmit() {
        return buttonSubmit;
    }

    public void setButtonSubmit(Button buttonSubmit) {
        this.buttonSubmit = buttonSubmit;
    }

}
