package com.myorg.gwt.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.myorg.gwt.client.layout.AppLayout;
import com.myorg.gwt.client.mvp.DemoActivityMapper;
import com.myorg.gwt.client.mvp.DemoPlaceHistoryMapper;
import com.myorg.gwt.client.mvp.activity.LoginActivity;
import com.myorg.gwt.client.mvp.place.LoginPlace;


public class MvpInActionEntryPoint implements EntryPoint {

    private SimplePanel containerWidget;
    private Place defaultPlace = new LoginPlace();
    private final ClientFactory clientFactory = GWT.create(ClientFactory.class);

    @Override
    public void onModuleLoad() {
        final AppLayout mainLayout = new AppLayout();
        containerWidget = mainLayout.getAppContentHolder();

        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // activate activity manager and init display
        ActivityMapper activityMapper = new DemoActivityMapper(clientFactory);
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
            ((LoginActivity) activityMapper.getActivity(defaultPlace))
                    .checkWithServerIfSessionIdIsStillLegal();
        }
    }

}
