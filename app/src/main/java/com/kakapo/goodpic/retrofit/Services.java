
package com.kakapo.goodpic.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.kakapo.goodpic.bean.MainResponseBean;

/**
 * Created by mustafasevgi on 14/02/16.
 */
public interface Services {
   @GET("/api/?key=1844050-e9795bd9528f243a9231fc96d&image_type=photo&response_group=high_resolution")
   Call<MainResponseBean> getMainPagePhotos(@Query("page") int page,
                                            @Query("order") String order,
                                            @Query("editor_choise") String editorChoise,
                                            @Query("category") String category);
}
