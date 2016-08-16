package com.myorg.gwt.file.client.mvp.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.myorg.gwt.file.client.mvp.presenter.FilePresenter;
import com.myorg.gwt.file.client.mvp.view.FileView;

public class FileActivity extends AbstractActivity {

    @Inject
    private FileView view;

    @Inject
    private FilePresenter presenter;
    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        presenter.init(view);
        container.setWidget(view.asWidget());
    }
}
