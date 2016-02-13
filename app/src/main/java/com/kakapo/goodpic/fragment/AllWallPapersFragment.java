
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
 * Created by mustafasevgi on 13/02/16.
 */
public class AllWallPapersFragment extends BaseFragment {
   private RecyclerView               recyclerView;
   private StaggeredGridLayoutManager manager;
   private BaseActivity               activity;

   @Override
   public int getLayoutResourceId() {
      return R.layout.fragment_allwallpapers;
   }

   public static AllWallPapersFragment newInstance(int position) {
      AllWallPapersFragment fragment = new AllWallPapersFragment();
      Bundle bundle = new Bundle();
      bundle.putInt("position", position);
      fragment.setArguments(bundle);
      return fragment;
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
