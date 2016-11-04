package com.myorg.gwt.users.client.mvp.presenter;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.myorg.gwt.common.client.proxy.UserProxy;
import com.myorg.gwt.common.client.request.UserRequestFactory;
import com.myorg.gwt.users.client.mvp.view.UsersView;

import java.util.List;

public class UsersPresenterImpl implements UsersPresenter {

    private UsersView view;

    @Inject
    UserRequestFactory userRequestFactory;

    @Override
    public void init(UsersView view) {
        this.view = view;
        view.setPresenter(this);
        userRequestFactory.getUserRequest().getUsersSortedByBirthday().fire(getReceiver());
    }

    private Receiver<List<UserProxy>> getReceiver() {
        return new Receiver<List<UserProxy>>() {

            @Override
            public void onSuccess(List<UserProxy> users) {
                view.renderUsers(users);
            }
        };
    }
}
