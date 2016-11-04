package com.myorg.gwt.users.client.mvp.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.myorg.gwt.common.client.proxy.UserProxy;
import com.myorg.gwt.users.client.i18n.UsersListConstants;
import com.myorg.gwt.users.client.mvp.presenter.UsersPresenter;
import com.myorg.gwt.users.client.mvp.view.UsersView;
import com.myorg.gwt.users.client.mvp.view.css.UsersResources;
import com.myorg.gwt.users.client.mvp.widget.UsersListTable;

import java.util.List;

public class UsersViewImpl extends Composite implements UsersView {

    private static UsersViewUiBinder uiBinder = GWT.create(UsersViewUiBinder.class);

    private UsersPresenter presenter;

    @Inject
    @UiField
    UsersResources css;

    @UiField
    UsersListTable userList;

    @Inject
    public UsersViewImpl(final UsersListConstants constants) {
        initWidget(uiBinder.createAndBindUi(this));
        userList.setUsersListConstants(constants);
    }

    @Override
    public void setPresenter(UsersPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void renderUsers(List<UserProxy> userProxyList) {
        userList.setData(userProxyList);
    }


    interface UsersViewUiBinder extends UiBinder<Widget, UsersViewImpl> {
    }
}