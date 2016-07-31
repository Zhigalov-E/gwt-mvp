package com.myorg.gwt.login.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.myorg.gwt.common.client.rpc.LoginRpcService;
import com.myorg.gwt.common.client.rpc.LoginRpcServiceAsync;
import com.myorg.gwt.common.shared.UserDTO;
import junit.framework.TestCase;
import org.junit.Test;


public class ServerTest extends GWTTestCase {

    @Test
    public void testLoginService() {
        // Create the service that we will test.
        LoginRpcServiceAsync loginService = GWT.create(LoginRpcService.class);
        ServiceDefTarget target = (ServiceDefTarget) loginService;
        target.setServiceEntryPoint(GWT.getModuleBaseURL() + "Login/login");
        // up to 10 seconds before timing out.
        delayTestFinish(10000);
        // Send a request to the server.
        loginService.loginServer("ivan", "secret", new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                // The request resulted in an unexpected error.
                TestCase.fail("Request failure: " + caught.getMessage());
            }

            @Override
            public void onSuccess(UserDTO userDTO) {
                // Verify that the response is correct.
                TestCase.assertTrue(userDTO.getLoggedIn());
                finishTest();
            }
        });
    }

    public String getModuleName() {
        return "com.myorg.gwt.login.client.LoginJUnit";
    }
}
