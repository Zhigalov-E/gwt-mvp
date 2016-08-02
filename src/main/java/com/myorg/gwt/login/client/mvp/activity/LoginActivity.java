package com.myorg.gwt.login.client.mvp.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myorg.gwt.login.client.mvp.presenter.LoginPresenter;
import com.myorg.gwt.login.client.mvp.view.LoginView;

public class LoginActivity extends AbstractActivity {

    @Inject
    private LoginView view;

    @Inject
    private LoginPresenter presenter;


    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        presenter.init(view);
        container.setWidget(view.asWidget());
    }


}
