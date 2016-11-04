package com.myorg.gwt.users.client.mvp.widget;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.myorg.gwt.common.client.proxy.UserProxy;
import com.myorg.gwt.users.client.i18n.UsersListConstants;

import java.util.List;

public class UsersListTable<T extends UserProxy> extends Composite {

    public static UsersListWidgetUiBinder uiBinder = GWT.create(UsersListWidgetUiBinder.class);

    private UsersListConstants usersListConstants;

    @UiField
    CellTable<T> clientTable;

    public UsersListTable() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setData(List<T> users) {
        clear();
        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T user) {
                return user.getId().toString();
            }
        }, usersListConstants.columnId());

        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T user) {
                return user.getLogin();
            }

        }, usersListConstants.columnLogin());

        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T user) {
                return user.getFirstName();
            }

        }, usersListConstants.columnFirstName());

        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T user) {
                return user.getLastName();
            }

        }, usersListConstants.columnLastName());

        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T user) {
                return user.getBirthday().toString();
            }

        }, usersListConstants.columnBirthday());

        clientTable.addColumn(new TextColumn<T>() {
            @Override
            public String getValue(T user) {
                return user.getEmail();
            }

        }, usersListConstants.columnEmail());

        clientTable.setPageSize(users.size());
        clientTable.setRowCount(users.size(), true);
        clientTable.setRowData(0, users);
    }

    public void clear() {
        int columnCount = clientTable.getColumnCount();
        for (int i = 0; i < columnCount; ++i) {
            clientTable.removeColumn(0);
        }
    }

    public void setUsersListConstants(UsersListConstants usersListConstants) {
        this.usersListConstants = usersListConstants;
    }

    public interface UsersListWidgetUiBinder extends UiBinder<Widget, UsersListTable<?>> {
    }
}
