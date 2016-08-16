package com.myorg.gwt.file.client.mvp.view.file;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.myorg.gwt.file.client.mvp.presenter.FilePresenter;
import com.myorg.gwt.file.client.mvp.view.FileView;
import com.myorg.gwt.file.client.mvp.view.css.FileResources;

import java.util.logging.Logger;

public class FileViewImpl extends Composite implements FileView {

    @UiTemplate("FileViewImpl.ui.xml")
    interface MainViewUiBinder extends UiBinder<Widget, FileViewImpl> {
    }
    private static final Logger LOGGER = Logger.getLogger(FileViewImpl.class.getName());
    private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

    private FilePresenter presenter;


    @UiField(provided = true)
    final FileResources css;

    @UiField
    FormPanel form;

    @UiField
    FileUpload uploadField;

    @UiField
    SubmitButton uploadButton;

    @UiField
    Button clearButton;

    @UiField
    TextArea clientData;

    @Inject
    public FileViewImpl(final FileResources css) {
        this.css = css;
        initWidget(uiBinder.createAndBindUi(this));
        initAcceptFormat();
    }

    @UiHandler("clearButton")
    public void onClickClearButton(ClickEvent clickEvent) {
        presenter.clearData();
    }

    @UiHandler("form")
    public void onSubmitForm(FormPanel.SubmitEvent event) {
        if(!presenter.isFileChoosen(uploadField.getFilename())) {
            event.cancel();
        }
    }

    @UiHandler("form")
    public void onCompleteForm(FormPanel.SubmitCompleteEvent event) {
        String srvResponse = event.getResults();
        presenter.onGetResponse(srvResponse);
    }

    @Override
    public void setPresenter(FilePresenter presenter) {
        this.presenter = presenter;
    }

    private void initAcceptFormat() {
        uploadField.getElement().setAttribute("accept", ".csv");
    }

    @Override
    public void clearData() {
        clientData.setText("");
    }

    @Override
    public void showData(String text) {
        clientData.setText(text);
    }
}