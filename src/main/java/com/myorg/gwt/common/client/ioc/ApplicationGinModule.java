package com.myorg.gwt.common.client.ioc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.myorg.gwt.common.client.i18n.AppMessages;
import com.myorg.gwt.common.client.request.UserRequestFactory;


public class ApplicationGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(PlaceController.class).to(InjectablePlaceController.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    AppMessages createAppMessages() {
        return GWT.create(AppMessages.class);
    }

    @Provides
    @Singleton
    UserRequestFactory createUserRequestFactory(EventBus eventBus) {
        UserRequestFactory requestFactory = GWT.create(UserRequestFactory.class);
        requestFactory.initialize(eventBus);
        return requestFactory;
    }

}
