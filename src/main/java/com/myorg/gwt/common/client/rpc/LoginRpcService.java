package com.myorg.gwt.common.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.myorg.gwt.common.shared.UserDTO;


@RemoteServiceRelativePath("springGwtServices/loginRpcService")
public interface LoginRpcService extends RemoteService {

    UserDTO loginFromSessionServer();

}