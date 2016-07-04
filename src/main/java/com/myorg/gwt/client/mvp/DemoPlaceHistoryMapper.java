package com.myorg.gwt.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.myorg.gwt.client.mvp.place.LoginPlace;
import com.myorg.gwt.client.mvp.place.MainPlace;

@WithTokenizers({MainPlace.Tokenizer.class, LoginPlace.Tokenizer.class})
public interface DemoPlaceHistoryMapper extends PlaceHistoryMapper {
}
