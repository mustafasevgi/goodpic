
package com.kakapo.goodpic.presenter;

import java.util.List;

import com.kakapo.goodpic.interactor.MainInteractor;
import com.kakapo.goodpic.interactor.MainInteractorImpl;
import com.kakapo.goodpic.view.MainView;
import com.kakapo.goodpic.listener.OnFinishedListener;
import com.kakapo.goodpic.model.Photo;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public class MainPresenterImpl implements MainPresenter, OnFinishedListener {
   private MainView mainView;
   private MainInteractor mainInteractor;

   public MainPresenterImpl(MainView mainView) {
      this.mainView = mainView;
      mainInteractor = new MainInteractorImpl();
   }

   @Override
   public void onItemClicked(int position) {

   }

   @Override
   public void getPhotos(int position, int page) {
      if (mainView != null) {
         mainView.showProgress();
      }
      mainInteractor.serviceMainPage(position, page, null, this);
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
