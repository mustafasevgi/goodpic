
package com.kakapo.goodpic.application;

import android.app.Application;

import com.kakapo.goodpic.retrofit.ApiProvider;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by mustafasevgi on 14/02/16.
 */
public class App extends Application {
   public static ApiProvider apiProvider;

   @Override
   public void onCreate() {
      super.onCreate();
      Fabric.with(this, new Crashlytics());
      apiProvider = new ApiProvider();
   }
}
