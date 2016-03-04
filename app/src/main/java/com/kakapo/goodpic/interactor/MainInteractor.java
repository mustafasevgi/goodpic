package com.kakapo.goodpic.interactor;


import com.kakapo.goodpic.listener.MainPageListener;
import com.kakapo.goodpic.listener.PhotoDetailListener;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public interface MainInteractor {
    void serviceMainPage(int position, int page, String category, String idHash, MainPageListener listener);

    void serviceGetPhoto(String photoId, PhotoDetailListener listener);
}
