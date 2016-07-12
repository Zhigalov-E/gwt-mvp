package com.myorg.gwt.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.myorg.gwt.shared.UserDTO;


public interface LoginRpcServiceAsync {

    void loginServer(String login, String password, AsyncCallback<UserDTO> asyncCallback);

    void loginFromSessionServer(AsyncCallback<UserDTO> asyncCallback);

    void logout(AsyncCallback asyncCallback);
}