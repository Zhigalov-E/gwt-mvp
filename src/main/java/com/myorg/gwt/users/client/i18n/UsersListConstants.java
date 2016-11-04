package com.myorg.gwt.users.client.i18n;


import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.LocalizableResource;

@LocalizableResource.DefaultLocale("en")
public interface UsersListConstants extends Constants {
    String columnId();
    String columnLogin();
    String columnFirstName();
    String columnLastName();
    String columnBirthday();
    String columnEmail();
}
