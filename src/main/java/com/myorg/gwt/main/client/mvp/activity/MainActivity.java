package com.myorg.gwt.main.client.mvp.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myorg.gwt.login.client.ClientFactory;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;
import com.myorg.gwt.main.client.mvp.view.MainView;

public class MainActivity extends AbstractActivity implements MainPresenter {
    private ClientFactory clientFactory;

    @Inject
    public MainActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        final MainView view = clientFactory.getMainView();
        view.setPresenter(this);
        container.setWidget(view.asWidget());
    }
}
