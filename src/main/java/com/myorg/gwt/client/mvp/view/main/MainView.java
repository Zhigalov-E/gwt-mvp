package com.myorg.gwt.client.mvp.view.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.myorg.gwt.client.mvp.view.IMainView;
import com.myorg.gwt.client.utils.TimeMessager;

import java.util.Date;

public class MainView extends Composite implements IMainView {
	interface MainViewUiBinder extends UiBinder<Widget, MainView> {	}
	private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);
	
	private IMainPresenter presenter;

	@UiField
	Label userGreeting;

	public MainView() {
		initWidget(uiBinder.createAndBindUi(this));
		setGreeting();
	}

	public void setGreeting() {
		String greeting = TimeMessager.getInstance().getMessageResouse(new Date());
		userGreeting.setText(greeting + ", Иван.");
	}

	public void setPresenter(IMainPresenter presenter) {
		this.presenter = presenter;
	}
}
