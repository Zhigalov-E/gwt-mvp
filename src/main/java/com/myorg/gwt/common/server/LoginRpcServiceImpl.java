package com.myorg.gwt.common.server;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myorg.gwt.common.client.rpc.LoginRpcService;
import com.myorg.gwt.common.shared.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashMap;
import java.util.Map;


public class LoginRpcServiceImpl extends RemoteServiceServlet implements LoginRpcService {

    private static final Logger LOGGER = Logger.getLogger(LoginRpcServiceImpl.class);
    private static final Map<String,String> USERS = new HashMap<>();

    {
        USERS.put("ivan","Иван");
        USERS.put("john","John");
    }

    @Override
    public UserDTO loginFromSessionServer() {
        return getUserAlreadyFromSession();
    }


    private UserDTO getUserAlreadyFromSession() {
        LOGGER.info("Check existing user session.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            LOGGER.warn("User session not exists.");
            return null;
        } else {
            UserDTO userDto = new UserDTO();
            String principal = authentication.getName();
            userDto.setName(USERS.get(principal));
            return userDto;
        }
    }
}
