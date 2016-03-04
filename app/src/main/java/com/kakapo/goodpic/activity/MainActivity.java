package com.kakapo.goodpic.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kakapo.goodpic.R;
import com.kakapo.goodpic.fragment.MainFragment;
import com.kakapo.goodpic.utils.Tools;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    public TabLayout tabs;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ImageView imageViewHeader;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public int getToggleType() {
        return TOGGLE_MENU;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);
        navigationView.addHeaderView(header);

        imageViewHeader = (ImageView) header.findViewById(R.id.imageview_header);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(R.dimen.nav_header_height));
        imageViewHeader.setLayoutParams(params);
        imageViewHeader.setDrawingCacheEnabled(true);

        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_container);
//            if (fragment != null && fragment instanceof MainFragment) {
//               ((MainFragment) fragment).viewPager.setCurrentItem(tab.getPosition());
//            }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_container);
                if (fragment != null && fragment instanceof MainFragment) {
                    ((MainFragment) fragment).scrollToTop(tab.getPosition());
                }
            }
        });
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        // toggle.syncState();
        setUpToolbar(TOGGLE_MENU, getString(R.string.app_name));
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            replaceFragment(this, R.id.main_container, new MainFragment(), MainFragment.TAG, false);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void openDrawer() {
        if (!drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageViewHeader.setImageDrawable(Tools.getCurrentWallpaper(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nature) {
            // Handle the camera action
        }
        // else if (id == R.id.nav_gallery) {
        //
        // }
        // else if (id == R.id.nav_slideshow) {
        //
        // }
        // else if (id == R.id.nav_manage) {
        //
        // }
        // else if (id == R.id.nav_share) {
        //
        // }
        // else if (id == R.id.nav_send) {
        //
        // }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
