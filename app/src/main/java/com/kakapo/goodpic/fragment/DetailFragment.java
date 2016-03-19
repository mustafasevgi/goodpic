package com.kakapo.goodpic.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kakapo.goodpic.R;
import com.kakapo.goodpic.activity.BaseActivity;
import com.kakapo.goodpic.custom_view.SquareSimpleDraweeImageView;
import com.kakapo.goodpic.model.Photo;
import com.kakapo.goodpic.presenter.DetailPresenter;
import com.kakapo.goodpic.presenter.DetailPresenterImpl;
import com.kakapo.goodpic.view.DetailView;

/**
 * Created by mustafasevgi on 24/02/16.
 */
public class DetailFragment extends BaseFragment implements DetailView, View.OnClickListener {
    public static final String ID_HASH = "id_hash";
    private String photoId;
    private Photo photo;
    private DetailPresenter detailPresenter;
    private SquareSimpleDraweeImageView imageView;
    private BaseActivity activity;

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
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (BaseActivity) context;
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
        view.findViewById(R.id.fab).setOnClickListener(this);
        imageView = (SquareSimpleDraweeImageView) view.findViewById(R.id.simpledraweeview);
        imageView.setOnClickListener(this);
        detailPresenter.getPhoto(photoId, photo);
    }

    @Override
    public void successPhoto(Photo photo) {
//        int width= Tools.getScreenWidth(activity);
//        int height = (photo.getWebformatHeight() * width) / photo.getWebformatWidth();
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
//        imageView.setLayoutParams(params);
        Uri uri = Uri.parse(photo.getWebformatURL());
        imageView.setImageURI(uri);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simpledraweeview:
                break;
            case R.id.fab:
                break;
        }
    }
}
