package com.kakapo.goodpic.application;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.kakapo.goodpic.model.Photo;
import com.kakapo.goodpic.retrofit.ApiProvider;

import java.util.HashMap;

import io.fabric.sdk.android.Fabric;

/**
 * Created by mustafasevgi on 14/02/16.
 */
public class App extends Application {
    public static ApiProvider apiProvider;
    public static HashMap<String, Photo> photoList;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        Fresco.initialize(this);
        apiProvider = new ApiProvider();
        photoList = new HashMap<>();
    }
}
