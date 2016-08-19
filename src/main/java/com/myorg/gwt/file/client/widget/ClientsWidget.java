package com.myorg.gwt.file.client.widget;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

public class ClientsWidget<T extends IClient> extends Composite {

    public static ClientsWidgetUiBinder uiBinder = GWT.create(ClientsWidgetUiBinder.class);

    @UiTemplate("ClientsWidget.ui.xml")
    public interface ClientsWidgetUiBinder extends UiBinder<Widget, ClientsWidget<?>> {
    }

    @UiField
    CellTable<T> clientTable;

    public ClientsWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setData(List<T> clients) {
        clear();
        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T t) {
                return t.getName();
            }
        }, "Name");

        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T t) {
                return t.getDate();
            }
        }, "Date");
        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T t) {
                return t.getEmail();
            }
        }, "Email");

        clientTable.setRowCount(clients.size(), true);
        clientTable.setRowData(0, clients);
    }

    public void clear() {
        int columnCount = clientTable.getColumnCount();
        for (int i = 0; i < columnCount; ++i) {
            clientTable.removeColumn(0);
        }
    }


}
