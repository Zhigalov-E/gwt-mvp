package com.myorg.gwt.application.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.myorg.gwt.file.client.mvp.place.FilePlace;
import com.myorg.gwt.main.client.mvp.place.MainPlace;
import com.myorg.gwt.users.client.mvp.place.UsersPlace;

@WithTokenizers({MainPlace.Tokenizer.class,
        FilePlace.Tokenizer.class,
        UsersPlace.Tokenizer.class})
public interface DemoPlaceHistoryMapper extends PlaceHistoryMapper {
}
