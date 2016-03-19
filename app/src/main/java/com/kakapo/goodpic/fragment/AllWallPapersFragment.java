package com.kakapo.goodpic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.kakapo.goodpic.adapter.MainRecyclerAdapter;
import com.kakapo.goodpic.R;
import com.kakapo.goodpic.activity.BaseActivity;
import com.kakapo.goodpic.application.App;
import com.kakapo.goodpic.constants.AppConstant;
import com.kakapo.goodpic.listener.EndlessScrollListener;
import com.kakapo.goodpic.model.Photo;
import com.kakapo.goodpic.presenter.MainPresenter;
import com.kakapo.goodpic.presenter.MainPresenterImpl;
import com.kakapo.goodpic.view.MainView;

import java.util.List;

/**
 * Created by mustafasevgi on 13/02/16.
 */
public class AllWallPapersFragment extends BaseFragment implements MainView, SwipeRefreshLayout.OnRefreshListener, MainRecyclerAdapter.RowClickListener {
    private SwipeRefreshLayout refreshLayout;
    private BaseActivity activity;
    private MainPresenter mainPresenter;
    private int position = AppConstant.TAB_POPULAR;
    private MainRecyclerAdapter adapter;
    private EndlessScrollListener scrollListener;
    private int page = 0;

    public static AllWallPapersFragment newInstance(int position) {
        AllWallPapersFragment fragment = new AllWallPapersFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_allwallpapers;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            activity = (BaseActivity) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            position = bundle.getInt("position");
        }
        mainPresenter = new MainPresenterImpl(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(AppConstant.COLOUMN_COUNT,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new MainRecyclerAdapter(activity, App.photoList, this);
        recyclerView.setAdapter(adapter);
        mainPresenter.getPhotos(position, page);
        refreshLayout.setOnRefreshListener(this);
        scrollListener = new EndlessScrollListener(activity, manager) {
            @Override
            public void onLoadMore() {
                page++;
                mainPresenter.getPhotos(position, page);
            }
        };
        recyclerView.addOnScrollListener(scrollListener);
    }

    @Override
    public void setItems(List<Photo> list) {
        App.photoList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void emptyMode() {

    }

    @Override
    public void showProgress() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void dismissProgress() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onDefaultAlert(String message) {

    }

    @Override
    public void onRefresh() {
        scrollListener.setPreviousTotal();
        page = 0;
        mainPresenter.getPhotos(position, page);
    }

    @Override
    public void onItemClickListener(int position, Photo photo) {
        mainPresenter.onItemClicked(activity, position, photo, photo.getIdHash());
    }
}
