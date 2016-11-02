package com.myorg.gwt.users.client.mvp.view.css;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface UsersResources extends ClientBundle {

    @Source("Users.css")
    UsersCss style();


    interface UsersCss extends CssResource {
        String userListData();
    }
}
