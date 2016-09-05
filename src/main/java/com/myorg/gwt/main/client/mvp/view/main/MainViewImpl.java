package com.myorg.gwt.main.client.mvp.view.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;
import com.myorg.gwt.main.client.mvp.view.MainView;
import com.myorg.gwt.main.client.mvp.view.css.MainResources;

import java.util.logging.Logger;

public class MainViewImpl extends Composite implements MainView {

    private static final Logger LOGGER = Logger.getLogger(MainViewImpl.class.getName());
    private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

    private MainPresenter presenter;

    @UiField(provided = true)
    final AppMessages i18n;

    @UiField(provided = true)
    final MainResources css;

    @UiField
    Label userGreeting;

    @Override
    public void setUserGreetingText(String userGreetingText) {
        this.userGreeting.setText(userGreetingText);
    }

    @Inject
    public MainViewImpl(final AppMessages i18n, final MainResources css) {
        this.css = css;
        this.i18n = i18n;
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("logOut")
    public void onClickLogOut(ClickEvent clickEvent) {

    }

    public void setPresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }

    public AppMessages getI18n() {
        return i18n;
    }


    interface MainViewUiBinder extends UiBinder<Widget, MainViewImpl> {
    }
}
