package com.myorg.gwt.application.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.myorg.gwt.file.client.mvp.place.FilePlace;
import com.myorg.gwt.login.client.mvp.place.LoginPlace;
import com.myorg.gwt.main.client.mvp.place.MainPlace;

@WithTokenizers({MainPlace.Tokenizer.class, LoginPlace.Tokenizer.class, FilePlace.Tokenizer.class})
public interface DemoPlaceHistoryMapper extends PlaceHistoryMapper {
}
