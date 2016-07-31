package com.myorg.gwt.login.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.myorg.gwt.login.client.mvp.view.ILoginView;
import com.myorg.gwt.main.client.mvp.view.IMainView;

public class ClientFactoryImpl implements ClientFactory {
    private EventBus eventBus;
    private PlaceController placeController;

    private IMainView mainView;
    private ILoginView loginView;

    @Inject
    public ClientFactoryImpl(final EventBus eventBus, final PlaceController placeController, final IMainView mainView, ILoginView loginView) {
        this.eventBus = eventBus;
        this.placeController = placeController;
        this.mainView = mainView;
        this.loginView = loginView;
    }

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public IMainView getMainView() {
        return mainView;
    }

    @Override
    public ILoginView getLoginView() {
        return loginView;
    }
}
