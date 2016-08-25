package com.myorg.gwt.file.client.i18n;


import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.LocalizableResource;

@LocalizableResource.DefaultLocale("en")
public interface FileConstants extends Constants {

    public String columnName();
    public String columnDate();
    public String columnEmail();
    public String uploadButtonName();
    public String clearButtonName();
}
