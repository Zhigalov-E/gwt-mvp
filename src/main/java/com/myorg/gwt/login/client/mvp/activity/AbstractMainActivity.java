package com.myorg.gwt.login.client.mvp.activity;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.myorg.gwt.login.client.AppConstants;

public abstract class AbstractMainActivity extends AbstractActivity {
    private static Map<String, Element> navLinks = new LinkedHashMap<String, Element>();

    static {
        navLinks.put(AppConstants.MAIN_LINK_ID, DOM.getElementById(AppConstants.MAIN_LINK_ID));
        navLinks.put(AppConstants.LOGIN_LINK_ID, DOM.getElementById(AppConstants.LOGIN_LINK_ID));
    }

    public void applyCurrentLinkStyle(String viewId) {
        for (String linkId : navLinks.keySet()) {
            final Element link = navLinks.get(linkId);
            if (link == null) continue;
            if (linkId.equals(viewId)) {
                link.addClassName("b-current");
            } else {
                link.removeClassName("b-current");
            }
        }
    }
}
