package com.myorg.gwt.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class MainPlace extends Place {
    private static final String VIEW_HISTORY_TOKEN = "main";

    public MainPlace() {
    }

    @Prefix(value = VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<MainPlace> {
        @Override
        public MainPlace getPlace(String token) {
            return new MainPlace();
        }

        @Override
        public String getToken(MainPlace place) {
            return "";
        }
    }
}
