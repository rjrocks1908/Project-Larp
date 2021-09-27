package com.haxon.larp;

import android.app.Application;

import com.onesignal.OneSignal;

public class MyApplication extends Application {

    private static final String ONESIGNAL_APP_ID = "d82f52fd-b044-4a9c-81c7-131105e2ae21";

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }

}
