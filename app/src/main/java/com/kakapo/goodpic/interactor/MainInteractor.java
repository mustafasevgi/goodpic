
package com.kakapo.goodpic.interactor;

import com.kakapo.goodpic.listener.OnFinishedListener;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public interface MainInteractor {
   void serviceMainPage(int position, int page, String category, OnFinishedListener listener);
}
