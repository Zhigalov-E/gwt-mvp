package com.myorg.gwt.main.client.mvp.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myorg.gwt.main.client.mvp.presenter.MainPresenter;
import com.myorg.gwt.main.client.mvp.view.MainView;

public class MainActivity extends AbstractActivity {

    @Inject
    private MainView view;

    @Inject
    private MainPresenter presenter;

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        presenter.init(view);
        container.setWidget(view.asWidget());
    }
}
