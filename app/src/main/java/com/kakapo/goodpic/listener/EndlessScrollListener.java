package com.kakapo.goodpic.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.kakapo.goodpic.utils.Tools;

/**
 * Created by MustafaS on 8.6.2015.
 */
public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    private static final float HIDE_THRESHOLD = 10;
    private static final float SHOW_THRESHOLD = 70;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    private int[] firstVisibleItems;
    private int mToolbarOffset = 0;
    private boolean mControlsVisible = true;
    private int mToolbarHeight;
    private int mTotalScrolledDistance;
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 8;
    private StaggeredGridLayoutManager layoutManager;

    public EndlessScrollListener(Context context, StaggeredGridLayoutManager layoutManager) {
        mToolbarHeight = Tools.getToolbarHeight(context);
        this.layoutManager = layoutManager;
    }

    public void setPreviousTotal() {
        previousTotal = 0;
        totalItemCount = 0;
        loading = true;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        clipToolbarOffset();

        if ((mToolbarOffset < mToolbarHeight && dy > 0) || (mToolbarOffset > 0 && dy < 0)) {
            mToolbarOffset += dy;
        }
        if (mTotalScrolledDistance < 0) {
            mTotalScrolledDistance = 0;
        } else {
            mTotalScrolledDistance += dy;
        }
        // for load more
        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = layoutManager.getItemCount();
        firstVisibleItems = layoutManager.findLastVisibleItemPositions(null);
        firstVisibleItem = getLastVisibleItem(firstVisibleItems);
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            // End has been reached

            Log.i("...", "end called");

            // Do something

            loading = true;
            onLoadMore();
        }
    }

    public int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            } else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }

    private void clipToolbarOffset() {
        if (mToolbarOffset > mToolbarHeight) {
            mToolbarOffset = mToolbarHeight;
        } else if (mToolbarOffset < 0) {
            mToolbarOffset = 0;
        }
    }

    public abstract void onLoadMore();
}
