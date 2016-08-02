package com.myorg.gwt.application.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.myorg.gwt.login.client.mvp.activity.LoginActivity;
import com.myorg.gwt.main.client.mvp.activity.MainActivity;
import com.myorg.gwt.login.client.mvp.place.LoginPlace;
import com.myorg.gwt.main.client.mvp.place.MainPlace;

import javax.inject.Inject;

public class DemoActivityMapper implements ActivityMapper {

    @Inject
    private LoginActivity loginActivity;

    @Inject
    private MainActivity mainActivity;

    @Inject
    private PlaceController placeController;

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof MainPlace) {
            return mainActivity;
        } else if (place instanceof LoginPlace) {
            return loginActivity;
        }
        return null;
    }
}
