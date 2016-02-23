
package com.kakapo.goodpic.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import com.kakapo.goodpic.constants.AppConstant;

/**
 * Created by mustafasevgi on 14/02/16.
 */
public class Api {
   private Services services;

   public Api() {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

      Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstant.BASE_URL)
                                                .addConverterFactory(GsonConverterFactory.create())
                                                .client(client)
                                                .build();
      services = retrofit.create(Services.class);
   }

   public Services getServices() {
      return services;
   }
}
