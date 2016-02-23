
package com.kakapo.goodpic.interactor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.kakapo.goodpic.listener.OnFinishedListener;
import com.kakapo.goodpic.application.App;
import com.kakapo.goodpic.bean.MainResponseBean;
import com.kakapo.goodpic.constants.AppConstant;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public class MainInteractorImpl implements MainInteractor {
   @Override
   public void serviceMainPage(int position, int page, String category, final OnFinishedListener listener) {
      String order = null;
      String editorChoise = null;
      switch (position) {
         case AppConstant.TAB_POPULAR :
            order = "popular";
            break;
         case AppConstant.TAB_LATEST :
            order = "latest";
            break;
         case AppConstant.TAB_EDITOR_ADVICE :
            editorChoise = "true";
            break;
      }
      Call<MainResponseBean> call = App.apiProvider.getApi().getServices().getMainPagePhotos(page, order, editorChoise, category);
      call.enqueue(new Callback<MainResponseBean>() {
         @Override
         public void onResponse(Call<MainResponseBean> call, Response<MainResponseBean> response) {
            if (response != null && response.body() != null && response.body().getHits() != null && response.body()
                                                                                                            .getHits()
                                                                                                            .size() > 0) {
               listener.onFinished(response.body().getHits());
            }
            else {
               listener.empty();
            }
         }

         @Override
         public void onFailure(Call<MainResponseBean> call, Throwable t) {
            listener.onDefaultError(t.getMessage());
         }
      });
   }
}
