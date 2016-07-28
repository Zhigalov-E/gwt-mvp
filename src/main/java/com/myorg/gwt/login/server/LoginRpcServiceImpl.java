package com.myorg.gwt.login.server;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.apache.log4j.Logger;
import com.myorg.gwt.login.client.rpc.LoginRpcService;
import com.myorg.gwt.login.server.dao.UserDAO;
import com.myorg.gwt.login.server.dao.UserDAOImpl;
import com.myorg.gwt.login.server.entity.User;
import com.myorg.gwt.login.server.utils.PasswordEncryptionService;
import com.myorg.gwt.login.shared.FieldVerifier;
import com.myorg.gwt.login.shared.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginRpcServiceImpl extends RemoteServiceServlet implements LoginRpcService {

    private static final Logger LOGGER = Logger.getLogger(LoginRpcServiceImpl.class);
    private final UserDAO userDAO;

    public LoginRpcServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public UserDTO loginServer(String login, String password) {
        if (!FieldVerifier.isValidName(login)
                || !FieldVerifier.isValidName(password)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(
                    "Name must be at least 3 characters long");
            LOGGER.error("Not valid login or password", illegalArgumentException);
            throw illegalArgumentException;
        }
        UserDTO userDTO = new UserDTO();
        User user = userDAO.getUserByLogin(login);
        if (user != null
                && PasswordEncryptionService.authenticate(password, user.getHashPwd())) {
            LOGGER.info("Success login and password.");
            userDTO.setLoggedIn(true);
            userDTO.setName(user.getName());
            storeUserInSession(userDTO);
        } else {
            LOGGER.warn("Wrong login or password.");
            userDTO.setLoggedIn(false);
        }
        return userDTO;
    }

    @Override
    public UserDTO loginFromSessionServer() {
        return getUserAlreadyFromSession();
    }

    @Override
    public void logout() {
        deleteUserFromSession();
    }

    private UserDTO getUserAlreadyFromSession() {
        LOGGER.info("Check existing user session.");
        UserDTO user = null;
        HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
        HttpSession session = httpServletRequest.getSession();
        Object userObj = session.getAttribute("user");
        if (userObj != null && userObj instanceof UserDTO) {
            LOGGER.info("User session not exists.");
            user = (UserDTO) userObj;
        }
        return user;
    }

    private void storeUserInSession(UserDTO user) {
        LOGGER.info("Login: store user session.");
        HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
        HttpSession session = httpServletRequest.getSession(true);
        user.setSessionId(session.getId());
        session.setAttribute("user", user);
    }

    private void deleteUserFromSession() {
        LOGGER.info("Logout: delete user session.");
        HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("user");
    }
}
