package com.kakapo.goodpic.presenter;

import com.kakapo.goodpic.interactor.MainInteractor;
import com.kakapo.goodpic.interactor.MainInteractorImpl;
import com.kakapo.goodpic.listener.PhotoDetailListener;
import com.kakapo.goodpic.model.Photo;
import com.kakapo.goodpic.view.DetailView;

/**
 * Created by mustafasevgi on 24/02/16.
 */
public class DetailPresenterImpl implements DetailPresenter, PhotoDetailListener {
    private DetailView detailView;
    private MainInteractor mainInteractor;

    public DetailPresenterImpl(DetailView detailView) {
        this.detailView = detailView;
        mainInteractor = new MainInteractorImpl();
    }


    @Override
    public void getPhoto(String photoId, Photo photo) {
        if (detailView != null) {
            if (photo != null) {
                detailView.successPhoto(photo);
            } else {
                detailView.showProgress();
                mainInteractor.serviceGetPhoto(photoId, this);
            }
        }
    }

    @Override
    public void onSuccessPhotoDetail(Photo photo) {
        if (detailView != null) {
            detailView.dismissProgress();
            detailView.successPhoto(photo);
        }
    }
}
