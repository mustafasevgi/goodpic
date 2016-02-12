
package com.kakapo.goodpic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.kakapo.goodpic.Adapter.MainRecyclerAdapter;
import com.kakapo.goodpic.R;
import com.kakapo.goodpic.activity.BaseActivity;

/**
 * Created by mustafasevgi on 12/02/16.
 */
public class MainFragment extends BaseFragment {
   public static final String         TAG = MainFragment.class.getSimpleName();
   private RecyclerView               recyclerView;
   private StaggeredGridLayoutManager manager;
   private BaseActivity               activity;

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
      recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
      manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
      recyclerView.setLayoutManager(manager);
      MainRecyclerAdapter adapter = new MainRecyclerAdapter(activity);
      recyclerView.setAdapter(adapter);
   }
}
