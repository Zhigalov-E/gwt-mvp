package com.myorg.gwt.login.client;


import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.myorg.gwt.common.client.layout.AppLayout;
import com.myorg.gwt.common.client.mvp.DemoPlaceHistoryMapper;
import com.myorg.gwt.login.client.ioc.LoginGinjector;
import com.myorg.gwt.login.client.mvp.place.LoginPlace;
import com.myorg.gwt.login.client.mvp.presenter.LoginPresenter;

import javax.inject.Inject;

public class Initializer {


    private static LoginGinjector injector = GWT.create(LoginGinjector.class);

    private SimplePanel containerWidget;

    @Inject
    private LoginPlace defaultPlace;

    @Inject
    private EventBus eventBus;

    @Inject
    private ActivityMapper activityMapper;

    @Inject
    private PlaceController placeController;

    @Inject
    private LoginPresenter loginPresenter;



    public void initApp() {

        final AppLayout mainLayout = new AppLayout();
        containerWidget = mainLayout.getAppContentHolder();

        // activate activity manager and init display
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(containerWidget);

        // display default view with activated history processing
        DemoPlaceHistoryMapper historyMapper = GWT.create(DemoPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

        RootLayoutPanel.get().add(mainLayout);
        historyHandler.handleCurrentHistory();
        //Check exists session
        if (Cookies.getCookie("sid") != null) {
            loginPresenter.checkWithServerIfSessionIdIsStillLegal();
        }
    }
}
