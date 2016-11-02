package com.myorg.gwt.application.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.myorg.gwt.file.client.mvp.activity.FileActivity;
import com.myorg.gwt.file.client.mvp.place.FilePlace;
import com.myorg.gwt.main.client.mvp.activity.MainActivity;
import com.myorg.gwt.main.client.mvp.place.MainPlace;
import com.myorg.gwt.users.client.mvp.activity.UsersActivity;
import com.myorg.gwt.users.client.mvp.place.UsersPlace;

import javax.inject.Inject;

public class DemoActivityMapper implements ActivityMapper {

    @Inject
    private MainActivity mainActivity;

    @Inject
    private FileActivity fileActivity;

    @Inject
    private UsersActivity usersActivity;

    @Inject
    private PlaceController placeController;


    @Override
    public Activity getActivity(Place place) {
        if (place instanceof MainPlace) {
            return mainActivity;
        } else if (place instanceof FilePlace) {
            return fileActivity;
        } else if (place instanceof UsersPlace) {
            return usersActivity;
        }
        return null;
    }
}
