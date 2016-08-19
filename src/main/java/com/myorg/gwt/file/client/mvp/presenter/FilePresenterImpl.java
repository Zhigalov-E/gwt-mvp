package com.myorg.gwt.file.client.mvp.presenter;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.myorg.gwt.file.client.i18n.FileUploadMessages;
import com.myorg.gwt.file.client.mvp.view.FileView;
import com.myorg.gwt.file.client.widget.IClient;

import java.util.ArrayList;
import java.util.List;

public class FilePresenterImpl implements FilePresenter {

    private FileView view;

    @Inject
    private FileUploadMessages fileUploadMessages;

    @Override
    public void init(FileView view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void clearData() {
        view.clearData();
    }

    @Override
    public boolean isFileChoosen(String filename) {
        boolean result = true;
        if ("".equals(filename)) {
            Window.alert(fileUploadMessages.fileNotSelected());
            result = false;
        }
        return  result;
    }

    @Override
    public void onGetResponse(String srvResponse) {
        if(srvResponse == null || srvResponse.equals("")) {
            Window.alert(fileUploadMessages.fileNotValid());
        } else {
            List<IClient> clients = parseJsonData(srvResponse);
            if(clients != null) {
                view.showData(clients);
            }
        }
    }

    private List<IClient> parseJsonData(String json) {
        JSONValue jsonValue = JSONParser.parseStrict(json);
        JSONObject clientsObject = jsonValue.isObject();
        JSONArray jsonArray = clientsObject.get("clients").isArray();

        if(jsonArray != null) {
            List<IClient> clients = new ArrayList<>(jsonArray.size());
            for (int i = 0 ; i < jsonArray.size(); ++i) {
                JSONObject jsonObject = jsonArray.get(i).isObject();
                String name = jsonObject.get("name").isString().stringValue();
                String date = jsonObject.get("date").isString().stringValue();
                String email = jsonObject.get("email").isString().stringValue();

                IClient client = new IClient(name, date, email);
                clients.add(client);
            }
            return  clients;
        }
        return null;
    }
}
