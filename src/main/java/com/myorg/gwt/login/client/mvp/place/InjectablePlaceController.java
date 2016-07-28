package com.myorg.gwt.login.client.mvp.place;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public class InjectablePlaceController extends PlaceController {

    @Inject
    public InjectablePlaceController(EventBus eventBus) {
        super(eventBus);
    }

}