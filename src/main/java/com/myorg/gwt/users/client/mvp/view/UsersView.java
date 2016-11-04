package com.myorg.gwt.users.client.mvp.view;


import com.google.gwt.user.client.ui.IsWidget;
import com.myorg.gwt.common.client.proxy.UserProxy;
import com.myorg.gwt.users.client.mvp.presenter.UsersPresenter;

import java.util.List;

public interface UsersView extends IsWidget {
    void setPresenter(UsersPresenter presenter);
    void renderUsers(List<UserProxy> userProxyList);
}
