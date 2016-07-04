package com.myorg.gwt.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class LoginPlace extends Place {
	private static final String VIEW_HISTORY_TOKEN = "login";
	
	public LoginPlace() { }
	
	@Prefix(value = VIEW_HISTORY_TOKEN)
	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {
		@Override
		public LoginPlace getPlace(String token) {
			return new LoginPlace();
		}

		@Override
		public String getToken(LoginPlace place) {
			return "";
		}
	}
}
