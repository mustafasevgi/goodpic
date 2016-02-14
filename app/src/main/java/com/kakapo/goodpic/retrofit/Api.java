
package com.kakapo.goodpic.retrofit;

import retrofit2.Retrofit;

import com.kakapo.goodpic.constants.AppConstant;

/**
 * Created by mustafasevgi on 14/02/16.
 */
public class Api {
   private Services services;

   public Api() {
      Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstant.BASE_URL).build();
      services = retrofit.create(Services.class);
   }

   public Services getServices() {
      return services;
   }
}
