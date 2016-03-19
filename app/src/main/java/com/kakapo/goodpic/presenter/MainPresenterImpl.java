package com.kakapo.goodpic.presenter;

import java.util.List;

import android.content.Intent;

import com.kakapo.goodpic.activity.BaseActivity;
import com.kakapo.goodpic.activity.DetailActivity;
import com.kakapo.goodpic.interactor.MainInteractor;
import com.kakapo.goodpic.interactor.MainInteractorImpl;
import com.kakapo.goodpic.listener.MainPageListener;
import com.kakapo.goodpic.model.Photo;
import com.kakapo.goodpic.view.MainView;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public class MainPresenterImpl implements MainPresenter, MainPageListener {
    private MainView mainView;
    private MainInteractor mainInteractor;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void onItemClicked(BaseActivity activity, int position, Photo photo, String photoId) {
        Intent intent = DetailActivity.getIntent(activity, position, photoId);
        DetailActivity.setPhoto(photo);
        activity.startActivity(intent);
    }

    @Override
    public void getPhotos(int position, int page) {
        if (mainView != null) {
            mainView.showProgress();
        }
        mainInteractor.serviceMainPage(position, page, null, null, this);
    }

    @Override
    public void onFinished(List<Photo> list) {
        if (mainView != null) {
            mainView.setItems(list);
            mainView.dismissProgress();
        }
    }

    @Override
    public void empty() {
        if (mainView != null) {
            mainView.dismissProgress();
            mainView.emptyMode();
        }
    }

    @Override
    public void onDefaultError(String message) {
        if (mainView != null) {
            mainView.onDefaultAlert(message);
        }
    }
}
