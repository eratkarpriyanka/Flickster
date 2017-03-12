package com.codepath.flickster.app;

import android.app.Application;
import android.content.Context;

public class Flickster extends Application{

    public static final String TAG = Flickster.class.getSimpleName();

    public  static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    @Override
    public Context getApplicationContext() {

        sContext = super.getApplicationContext();
        return sContext;
    }

}
