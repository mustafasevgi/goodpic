
package com.kakapo.goodpic.Adapter;

import java.util.List;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kakapo.goodpic.R;
import com.kakapo.goodpic.activity.BaseActivity;
import com.kakapo.goodpic.constants.AppConstant;
import com.kakapo.goodpic.fragment.AllWallPapersFragment;
import com.kakapo.goodpic.model.Photo;
import com.kakapo.goodpic.utils.Tools;

/**
 * Created by mustafasevgi on 12/02/16.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.Holder> {
   private final BaseActivity activity;
   private List<Photo>        list;
   private int                coloumnWidth;

   public MainRecyclerAdapter(BaseActivity activity, List<Photo> list) {
      this.activity = activity;
      this.list = list;
      coloumnWidth = Tools.getScreenWidth(activity) / AppConstant.COLOUMN_COUNT;
   }

   @Override
   public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new Holder(LayoutInflater.from(activity).inflate(R.layout.row_mainrecycler, parent, false));
   }

   @Override
   public void onBindViewHolder(Holder holder, int position) {
      Photo item = list.get(position);
      if (item != null) {
         int rowHeight = (item.getPreviewHeight() * coloumnWidth) / item.getPreviewWidth();
         FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(coloumnWidth, rowHeight);
         holder.imageView.setLayoutParams(params);
         holder.imageView.setImageURI(Uri.parse(item.getPreviewURL()));
      }
   }

   @Override
   public int getItemCount() {
      return list.size();
   }

   class Holder extends RecyclerView.ViewHolder {
      private SimpleDraweeView imageView;

      public Holder(View view) {
         super(view);
         imageView = (SimpleDraweeView) view.findViewById(R.id.imageView);
      }
   }
}
