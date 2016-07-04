package com.myorg.gwt.client.mvp.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.myorg.gwt.client.mvp.view.ILoginView;

public class LoginView extends Composite implements ILoginView {
	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {	}
	private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);
	
	private ILoginPresenter presenter;

	@UiField
	Button buttonSubmit;
	
	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(ILoginPresenter presenter) {
		this.presenter = presenter;
	}


	@UiHandler("buttonSubmit")
	void doClickSubmit(ClickEvent event) {
		Window.Location.assign("#main:");
	}
}
