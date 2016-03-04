package com.kakapo.goodpic.view;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public interface BaseView {
    void showProgress();


    void dismissProgress();

    void onDefaultAlert(String message);
}
