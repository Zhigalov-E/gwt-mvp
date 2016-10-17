package com.myorg.gwt.common.server.rpc;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myorg.gwt.common.client.rpc.LoginRpcService;
import com.myorg.gwt.common.server.service.UserService;
import com.myorg.gwt.common.shared.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("loginRpcService")
public class LoginRpcServiceImpl extends RemoteServiceServlet implements LoginRpcService {

    private static final Logger LOGGER = Logger.getLogger(LoginRpcServiceImpl.class);

    @Autowired
    UserService userService;

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
            userDto.setName(userService.getUserByLogin(
                    authentication.getName()).getFirstName());
            return userDto;
        }
    }
}
