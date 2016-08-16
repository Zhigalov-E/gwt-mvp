package com.myorg.gwt.file.client.mvp.view.css;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface FileResources extends ClientBundle {

    @Source("File.css")
    MainCss style();

    interface MainCss extends CssResource {
        String fileLoadForm();
        String clientData();
        String botton();
    }
}
