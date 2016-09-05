package com.myorg.gwt.application.client;


import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.myorg.gwt.application.client.ioc.AppGinjector;
import com.myorg.gwt.application.client.mvp.DemoPlaceHistoryMapper;
import com.myorg.gwt.common.client.layout.AppLayout;
import com.myorg.gwt.main.client.mvp.place.MainPlace;

import javax.inject.Inject;

public class ApplicationLauncher {

    private static AppGinjector injector = GWT.create(AppGinjector.class);

    private SimplePanel containerWidget;

    @Inject
    private MainPlace defaultPlace;

    @Inject
    private EventBus eventBus;

    @Inject
    private ActivityMapper activityMapper;

    @Inject
    private PlaceController placeController;

    public void launch() {
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
    }
}
