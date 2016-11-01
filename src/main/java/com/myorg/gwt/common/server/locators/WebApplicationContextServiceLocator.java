package com.myorg.gwt.common.server.locators;


import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class WebApplicationContextServiceLocator implements ServiceLocator {
    @Override
    public Object getInstance(Class<?> clazz) {
        HttpServletRequest request = RequestFactoryServlet.getThreadLocalRequest();
        ServletContext servletContext = request.getSession().getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext( servletContext );
        return context.getBean(clazz);
    }
}
