package com.kakapo.goodpic.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.kakapo.goodpic.R;
import com.kakapo.goodpic.activity.BaseActivity;
import com.kakapo.goodpic.fragment.AllWallPapersFragment;

/**
 * Created by MustafaS on 17.12.2015.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {
    SparseArray<Fragment> registeredFragments = new SparseArray<>();
    private String[] titles;

    public MainPagerAdapter(FragmentManager fm, BaseActivity activity) {
        super(fm);
        titles = activity.getResources().getStringArray(R.array.tab_titles);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public AllWallPapersFragment getItem(int position) {
        return AllWallPapersFragment.newInstance(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}
