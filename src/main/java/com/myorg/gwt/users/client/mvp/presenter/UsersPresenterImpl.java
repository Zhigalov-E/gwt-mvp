package com.myorg.gwt.users.client.mvp.presenter;

import com.myorg.gwt.users.client.mvp.view.UsersView;

public class UsersPresenterImpl implements UsersPresenter {

    private UsersView view;

    @Override
    public void init(UsersView view) {
        this.view = view;
        view.setPresenter(this);
    }
}
