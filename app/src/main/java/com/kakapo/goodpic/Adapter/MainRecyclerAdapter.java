
package com.kakapo.goodpic.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kakapo.goodpic.R;

/**
 * Created by mustafasevgi on 12/02/16.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.Holder> {
   private final Context context;

   public MainRecyclerAdapter(Context context) {
      this.context = context;
   }

   @Override
   public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new Holder(LayoutInflater.from(context).inflate(R.layout.row_mainrecycler, parent, false));
   }

   @Override
   public void onBindViewHolder(Holder holder, int position) {

   }

   @Override
   public int getItemCount() {
      return 30;
   }

   class Holder extends RecyclerView.ViewHolder {

      public Holder(View itemView) {
         super(itemView);
      }
   }
}
