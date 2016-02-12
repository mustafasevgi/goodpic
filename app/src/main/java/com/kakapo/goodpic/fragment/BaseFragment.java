
package com.kakapo.goodpic.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mustafasevgi on 12/02/16.
 */
public abstract class BaseFragment extends Fragment {
   @LayoutRes
   public abstract int getLayoutResourceId();

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = LayoutInflater.from(getContext()).inflate(getLayoutResourceId(), container, false);
      return view;
   }
}
