
package com.kakapo.goodpic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.kakapo.goodpic.Adapter.MainPagerAdapter;
import com.kakapo.goodpic.R;
import com.kakapo.goodpic.activity.BaseActivity;
import com.kakapo.goodpic.activity.MainActivity;

/**
 * Created by mustafasevgi on 12/02/16.
 */
public class MainFragment extends BaseFragment {
   public static final String TAG = MainFragment.class.getSimpleName();
   private BaseActivity       activity;
   private ViewPager          viewPager;

   @Override
   public int getLayoutResourceId() {
      return R.layout.fragment_main;
   }

   @Override
   public void onAttach(Context context) {
      super.onAttach(context);
      if (context instanceof BaseActivity) {
         activity = (BaseActivity) context;
      }
   }

   @Override
   public void onViewCreated(View view, Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      viewPager = (ViewPager) view.findViewById(R.id.viewpager);
      MainPagerAdapter adapter = new MainPagerAdapter(getChildFragmentManager(), activity);
      viewPager.setAdapter(adapter);
      viewPager.setOffscreenPageLimit(2);
   }

   @Override
   public void onActivityCreated(Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
      if (activity instanceof MainActivity)
         ((MainActivity) activity).tabs.setupWithViewPager(viewPager);
   }
}
