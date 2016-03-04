package com.kakapo.goodpic.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.kakapo.goodpic.R;
import com.kakapo.goodpic.activity.BaseActivity;
import com.kakapo.goodpic.model.Photo;
import com.kakapo.goodpic.presenter.DetailPresenter;
import com.kakapo.goodpic.presenter.DetailPresenterImpl;
import com.kakapo.goodpic.view.DetailView;

/**
 * Created by mustafasevgi on 24/02/16.
 */
public class DetailFragment extends BaseFragment implements DetailView {
    public static final String ID_HASH = "id_hash";
    private String photoId;
    private Photo photo;
    private DetailPresenter detailPresenter;

    public static Fragment newInstance(BaseActivity activity, String photoId) {
        Bundle bundle = new Bundle();
        bundle.putString(ID_HASH, photoId);
        return Fragment.instantiate(activity, DetailFragment.class.getName(), bundle);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_detail;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            photoId = bundle.getString(ID_HASH, "");
        }
        detailPresenter = new DetailPresenterImpl(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailPresenter.getPhoto(photoId, photo);
    }

    @Override
    public void successPhoto(Photo photo) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void onDefaultAlert(String message) {

    }
}
