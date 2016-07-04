package com.myorg.gwt.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.myorg.gwt.client.mvp.view.ILoginView;
import com.myorg.gwt.client.mvp.view.IMainView;
import com.myorg.gwt.client.mvp.view.login.LoginView;
import com.myorg.gwt.client.mvp.view.main.MainView;

public class ClientFactoryImpl implements ClientFactory {
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);
	
	private final IMainView mainView = new MainView();
	private final ILoginView loginView = new LoginView();
	
	@Override public EventBus getEventBus() { return eventBus; }
	@Override public PlaceController getPlaceController() { return placeController; }
	@Override public IMainView getMainView() { return mainView; }
	@Override public ILoginView getLoginView() { return loginView; }
}
