package com.myorg.gwt.client.mvp.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface ILoginView extends IsWidget {
    public void setPresenter(ILoginPresenter presenter);

    public interface ILoginPresenter {
    }
}
