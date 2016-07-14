package com.myorg.gwt.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.myorg.gwt.client.mvp.view.ILoginView;
import com.myorg.gwt.client.mvp.view.IMainView;

public interface ClientFactory {
    EventBus getEventBus();

    PlaceController getPlaceController();

    IMainView getMainView();

    ILoginView getLoginView();
}
