
package com.kakapo.goodpic.view;

import java.util.List;

import com.kakapo.goodpic.model.Photo;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public interface BaseView {
   void showProgress();



   void dismissProgress();
    void onDefaultAlert(String message);
}
