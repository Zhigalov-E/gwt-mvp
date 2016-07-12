package com.myorg.gwt.client.mvp.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.myorg.gwt.client.AppConstants;
import com.myorg.gwt.client.ClientFactory;
import com.myorg.gwt.client.mvp.view.ILoginView;

public class LoginActivity extends AbstractMainActivity implements ILoginView.ILoginPresenter {
    private ClientFactory clientFactory;

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
}
