package com.myorg.gwt.users.client.mvp.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myorg.gwt.users.client.mvp.presenter.UsersPresenter;
import com.myorg.gwt.users.client.mvp.view.UsersView;

public class UsersActivity extends AbstractActivity {

    @Inject
    private UsersView view;

    @Inject
    private UsersPresenter presenter;

    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        presenter.init(view);
        acceptsOneWidget.setWidget(view.asWidget());
    }
}
