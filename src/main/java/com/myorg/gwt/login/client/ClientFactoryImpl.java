package com.myorg.gwt.login.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.myorg.gwt.login.client.mvp.view.LoginView;
import com.myorg.gwt.main.client.mvp.view.MainView;

public class ClientFactoryImpl implements ClientFactory {
    private EventBus eventBus;
    private PlaceController placeController;

    private MainView mainView;
    private LoginView loginView;

    @Inject
    public ClientFactoryImpl(final EventBus eventBus, final PlaceController placeController, final MainView mainView, LoginView loginView) {
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
    public MainView getMainView() {
        return mainView;
    }

    @Override
    public LoginView getLoginView() {
        return loginView;
    }
}
