package com.myorg.gwt.login.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.myorg.gwt.login.client.mvp.view.LoginView;
import com.myorg.gwt.main.client.mvp.view.MainView;

public interface ClientFactory {
    EventBus getEventBus();

    PlaceController getPlaceController();

    MainView getMainView();

    LoginView getLoginView();
}
