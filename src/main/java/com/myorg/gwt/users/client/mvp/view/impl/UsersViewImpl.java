package com.myorg.gwt.users.client.mvp.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.myorg.gwt.file.client.widget.ClientsTable;
import com.myorg.gwt.users.client.mvp.presenter.UsersPresenter;
import com.myorg.gwt.users.client.mvp.view.UsersView;
import com.myorg.gwt.users.client.mvp.view.css.UsersResources;

public class UsersViewImpl extends Composite implements UsersView {

    interface UsersViewUiBinder extends UiBinder<Widget, UsersViewImpl> {
    }

    private static UsersViewUiBinder uiBinder = GWT.create(UsersViewUiBinder.class);

    private UsersPresenter presenter;

    @UiField(provided = true)
    final UsersResources css;
    @UiField
    ClientsTable userList;

    @Inject
    public UsersViewImpl(final UsersResources css) {
        this.css = css;
        initWidget(uiBinder.createAndBindUi(this));
        //userList.setFileResources(css);
        //clientData.setFileConstants(fileConstants);
    }

    @Override
    public void setPresenter(UsersPresenter presenter) {
        this.presenter = presenter;
    }
}