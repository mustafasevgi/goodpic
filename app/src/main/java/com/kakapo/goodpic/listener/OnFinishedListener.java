
package com.kakapo.goodpic.listener;

import java.util.List;

import com.kakapo.goodpic.model.Photo;

/**
 * Created by mustafasevgi on 16/02/16.
 */
public interface OnFinishedListener {
   void onFinished(List<Photo> list);

   void empty();

   void onDefaultError(String message);
}
