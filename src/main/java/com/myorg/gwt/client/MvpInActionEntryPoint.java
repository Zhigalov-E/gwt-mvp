package com.myorg.gwt.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.myorg.gwt.client.i18n.AppMessages;
import com.myorg.gwt.client.layout.AppLayout;
import com.myorg.gwt.client.mvp.DemoActivityMapper;
import com.myorg.gwt.client.mvp.DemoPlaceHistoryMapper;
import com.myorg.gwt.client.mvp.place.LoginPlace;
import com.myorg.gwt.client.mvp.view.main.MainView;
import com.myorg.gwt.client.rpc.LoginRpcService;
import com.myorg.gwt.client.utils.TimeMessager;
import com.myorg.gwt.shared.UserDTO;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MvpInActionEntryPoint implements EntryPoint {
    private static final Logger LOGGER = Logger.getLogger(MainView.class.getName());

    private SimplePanel containerWidget;
    private LoginPlace defaultPlace = new LoginPlace();
    private final ClientFactory clientFactory = GWT.create(ClientFactory.class);

    private final AppMessages i18n = GWT.create(AppMessages.class);

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
        //TODO
        /*String sessionID = Cookies.getCookie("sid");
        if (sessionID == null) {
            loginView.showLogin();
        } else {
            checkWithServerIfSessionIdIsStillLegal();
        }*/
    }

    private void checkWithServerIfSessionIdIsStillLegal() {
        LoginRpcService.Util.getInstance().loginFromSessionServer(new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                LOGGER.log(Level.SEVERE, "Error with check login session.", caught);
                Window.Location.assign("#login:");
            }

            @Override
            public void onSuccess(UserDTO result) {
                if (result == null) {
                    Window.Location.assign("#login:");
                } else {
                    if (result.getLoggedIn()) {
                        LOGGER.log(Level.INFO, "Go to home page, user session is still valid.");
                        showHomePage(result);
                    } else {
                        LOGGER.log(Level.INFO, "User session has expired.");
                        Window.Location.assign("#login:");
                    }
                }
            }

        });
    }

    public void showHomePage(UserDTO userDTO) {
        String greeting = TimeMessager.getInstance().getMessageResouse(new Date());
        String userGreeting = getI18n().userGreeting(greeting, userDTO.getName());
        MainView mainView = (MainView)clientFactory.getMainView();
        mainView.getUserGreeting().setText(userGreeting);

        Window.Location.assign("#main:");
    }

    public AppMessages getI18n() {
        return i18n;
    }


}
