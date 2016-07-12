package com.myorg.gwt.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.myorg.gwt.client.ClientFactory;
import com.myorg.gwt.client.mvp.activity.LoginActivity;
import com.myorg.gwt.client.mvp.activity.MainActivity;
import com.myorg.gwt.client.mvp.place.LoginPlace;
import com.myorg.gwt.client.mvp.place.MainPlace;

public class DemoActivityMapper implements ActivityMapper {
    private ClientFactory clientFactory;

    public DemoActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof MainPlace) {
            return new MainActivity(clientFactory);
        } else if (place instanceof LoginPlace) {
            return new LoginActivity(clientFactory);
        }
        return null;
    }
}
