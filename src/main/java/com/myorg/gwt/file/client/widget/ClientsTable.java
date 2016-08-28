package com.myorg.gwt.file.client.widget;


import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.myorg.gwt.file.client.i18n.FileConstants;
import com.myorg.gwt.file.client.mvp.view.css.FileResources;

import java.util.List;

public class ClientsTable<T extends IClient> extends Composite {

    public static ClientsWidgetUiBinder uiBinder = GWT.create(ClientsWidgetUiBinder.class);

    private FileResources fileResources;

    private FileConstants fileConstants;

    @UiField
    CellTable<T> clientTable;

    public ClientsTable() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setData(List<T> clients) {
        clear();
        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T t) {
                return t.getName();
            }
        }, fileConstants.columnName());

        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T t) {
                return t.getDate();
            }

            @Override
            public String getCellStyleNames(Cell.Context context, T object) {
                String style = null;
                if(object.getDate() == null) {
                    style = fileResources.style().redBackground();
                }
                return style;
            }
        }, fileConstants.columnDate());

        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T t) {
                return t.getEmail();
            }

            @Override
            public String getCellStyleNames(Cell.Context context, T object) {
                String style = null;
                if(object.getEmail() == null) {
                    style = fileResources.style().redBackground();
                }
                return style;
            }

        }, fileConstants.columnEmail());
        clientTable.setPageSize(clients.size());
        clientTable.setRowCount(clients.size(), true);
        clientTable.setRowData(0, clients);

    }

    public void clear() {
        int columnCount = clientTable.getColumnCount();
        for (int i = 0; i < columnCount; ++i) {
            clientTable.removeColumn(0);
        }
    }

    public void setFileResources(FileResources fileResources) {
        this.fileResources = fileResources;
    }

    public void setFileConstants(FileConstants fileConstants) {
        this.fileConstants = fileConstants;
    }

    public interface ClientsWidgetUiBinder extends UiBinder<Widget, ClientsTable<?>> {
    }
}
