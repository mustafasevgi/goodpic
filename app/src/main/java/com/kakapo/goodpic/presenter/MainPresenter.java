
package com.kakapo.goodpic.presenter;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public interface MainPresenter {
   void onItemClicked(int position);

   void getPhotos(int position,int page);
}
