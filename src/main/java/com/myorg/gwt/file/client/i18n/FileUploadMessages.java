package com.myorg.gwt.file.client.i18n;


import com.google.gwt.i18n.client.LocalizableResource;
import com.google.gwt.i18n.client.Messages;

@LocalizableResource.DefaultLocale("en")
public interface FileUploadMessages extends Messages {
    String fileNotSelected();
    String fileUnexpectedError();
    String fileBadFormat();
    String fileSizeLimit();
    String fileIsEmpty();
    String fileBadDataFormat();
}
