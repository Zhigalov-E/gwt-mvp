package com.myorg.gwt.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.myorg.gwt.shared.UserDTO;


@RemoteServiceRelativePath("login")
public interface LoginRpcService extends RemoteService {

    /**
     * Utility class for simplifying access to the instance of async service.
     */
    class Util {
        private static LoginRpcServiceAsync instance;

        public static LoginRpcServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(LoginRpcService.class);
            }
            return instance;
        }
    }

    UserDTO loginServer(String login, String password);

    UserDTO loginFromSessionServer();

    void logout();
}