
package com.kakapo.goodpic.activity;

import static com.kakapo.goodpic.R.id.toolbar_toggle;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kakapo.goodpic.R;
import com.kakapo.goodpic.fragment.BaseFragment;

/**
 * Created by mustafasevgi on 12/02/16.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
   public static final int TOGGLE_BACK = 0;
   public static final int TOGGLE_MENU = 1;
   public Toolbar          toolbar;
   public ImageView        toolbarToggle;
   public TextView         toolbarTitle;

   @LayoutRes
   public abstract int getLayoutResourceId();

   public abstract Toolbar getToolbar();

   public abstract int getToggleType();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(getLayoutResourceId());
      if (getToolbar() != null) {
         setSupportActionBar(getToolbar());
         if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);
         toolbar = getToolbar();
         toolbarToggle = (ImageView) toolbar.findViewById(toolbar_toggle);
         toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
         toolbarToggle.setOnClickListener(this);
      }
   }

   public void replaceFragment(BaseActivity activity, int resourceId, BaseFragment fragment, String tag, boolean backTostack) {
      android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
      transaction.replace(resourceId, fragment, tag);
      if (backTostack) {
         transaction.addToBackStack(null);
      }
      transaction.commit();
   }

   public void setUpToolbar(int toggleType, String title) {
      if (toolbarToggle != null) {
         switch (toggleType) {
            case TOGGLE_BACK :
               toolbarToggle.setImageResource(R.drawable.ic_arrow_back);
               break;
            case TOGGLE_MENU :
               toolbarToggle.setImageResource(R.drawable.ic_menu);
               break;
         }
      }
      if (toolbarTitle != null) {
         toolbarTitle.setText(title);
      }
   }

   @Override
   public void onClick(View view) {
      switch (view.getId()) {
         case R.id.toolbar_toggle :
            switch (getToggleType()) {
               case TOGGLE_BACK :
                  onBackPressed();
                  break;
               case TOGGLE_MENU :
                  if (this instanceof MainActivity)
                     ((MainActivity) this).openDrawer();
                  break;
            }
            break;
      }
   }
}
