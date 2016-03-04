package com.kakapo.goodpic.interactor;

import com.kakapo.goodpic.application.App;
import com.kakapo.goodpic.bean.MainResponseBean;
import com.kakapo.goodpic.constants.AppConstant;
import com.kakapo.goodpic.listener.MainPageListener;
import com.kakapo.goodpic.listener.PhotoDetailListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public class MainInteractorImpl implements MainInteractor {
    @Override
    public void serviceMainPage(int position, int page, String category, String idHash, final MainPageListener listener) {
        String order = null;
        String editorChoise = null;
        switch (position) {
            case AppConstant.TAB_POPULAR:
                order = "popular";
                break;
            case AppConstant.TAB_LATEST:
                order = "latest";
                break;
            case AppConstant.TAB_EDITOR_ADVICE:
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
                } else {
                    listener.empty();
                }
            }

            @Override
            public void onFailure(Call<MainResponseBean> call, Throwable t) {
                listener.onDefaultError(t.getMessage());
            }
        });
    }

    @Override
    public void serviceGetPhoto(String photoId, final PhotoDetailListener listener) {
        Call<MainResponseBean> call = App.apiProvider.getApi().getServices().getPhotoDetail(photoId);
        call.enqueue(new Callback<MainResponseBean>() {
            @Override
            public void onResponse(Call<MainResponseBean> call, Response<MainResponseBean> response) {
                if (response != null && response.body() != null && response.body().getHits() != null && response.body().getHits().size() > 0) {
                    listener.onSuccessPhotoDetail(response.body().getHits().get(0));
                }
            }

            @Override
            public void onFailure(Call<MainResponseBean> call, Throwable t) {

            }
        });
    }
}
