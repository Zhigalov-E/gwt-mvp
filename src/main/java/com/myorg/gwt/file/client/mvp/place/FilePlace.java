package com.myorg.gwt.file.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class FilePlace extends Place {
    private static final String VIEW_HISTORY_TOKEN = "file";

    public FilePlace() {
    }

    @Prefix(value = VIEW_HISTORY_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<FilePlace> {
        @Override
        public FilePlace getPlace(String token) {
            return new FilePlace();
        }

        @Override
        public String getToken(FilePlace place) {
            return "";
        }
    }
}
