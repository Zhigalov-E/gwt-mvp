package com.myorg.gwt.main.client.mvp.view.css;


import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface MainResources extends ClientBundle {

    @Source("Main.css")
    MainCss style();

    interface MainCss extends CssResource {
        String fileLoadForm();
        String greetingBox();
    }
}
