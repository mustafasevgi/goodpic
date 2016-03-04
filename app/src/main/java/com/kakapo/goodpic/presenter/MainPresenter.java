package com.kakapo.goodpic.presenter;

import com.kakapo.goodpic.activity.BaseActivity;
import com.kakapo.goodpic.model.Photo;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public interface MainPresenter {
    void onItemClicked(BaseActivity activity, int position, Photo photo, String photoId);

    void getPhotos(int position, int page);
}
