package com.kakapo.goodpic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.kakapo.goodpic.R;
import com.kakapo.goodpic.fragment.DetailFragment;
import com.kakapo.goodpic.model.Photo;

/**
 * Created by mustafasevgi on 14/02/16.
 */
public class DetailActivity extends BaseActivity {
    private Photo photo;

    public static Intent getIntent(BaseActivity activity, int position, String photoId) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("photo_id", photoId);
        return intent;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_detail;
    }

    @Override
    public Toolbar getToolbar() {
        return null;
    }

    @Override
    public int getToggleType() {
        return TOGGLE_BACK;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String photoId = "";
        if (bundle != null) {
            photoId = bundle.getString("photo_id");
        }
        if (savedInstanceState == null) {
            Fragment fragment = DetailFragment.newInstance(this, photoId);
            ((DetailFragment) fragment).setPhoto(photo);
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, fragment).commit();
        }
    }
}
