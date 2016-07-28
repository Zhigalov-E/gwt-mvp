package com.myorg.gwt.login.client.mvp.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myorg.gwt.login.client.AppConstants;
import com.myorg.gwt.login.client.ClientFactory;
import com.myorg.gwt.login.client.mvp.view.IMainView;

public class MainActivity extends AbstractMainActivity implements IMainView.IMainPresenter {
    private ClientFactory clientFactory;

    @Inject
    public MainActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        applyCurrentLinkStyle(AppConstants.MAIN_LINK_ID);

        final IMainView view = clientFactory.getMainView();
        view.setPresenter(this);
        container.setWidget(view.asWidget());
    }
}
