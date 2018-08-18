package www.performancelab.com.vkontaktetest.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.common.BaseAdapter;
import www.performancelab.com.vkontaktetest.model.view.BaseViewModel;
import www.performancelab.com.vkontaktetest.mvp.presenter.BaseFeedPresenter;
import www.performancelab.com.vkontaktetest.mvp.view.BaseFeedView;

public abstract class BaseFeedFragment extends BaseFragment implements BaseFeedView{

    RecyclerView mRecyclerView;
    BaseAdapter mAdapter;

    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected ProgressBar mProgressBar;

    protected BaseFeedPresenter mBaseFeedPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
        setUpSwipeToRefreshLayout(view);

        mBaseFeedPresenter = onCreateFeedPresenter();
        mBaseFeedPresenter.loadStart();
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    private void setUpRecyclerView(View rootView){
        mRecyclerView = rootView.findViewById(R.id.rv_List);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter(RecyclerView rv){
        mAdapter = new BaseAdapter();
        rv.setAdapter(mAdapter);
    }

    public void setUpSwipeToRefreshLayout(View rootView){
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(() -> onCreateFeedPresenter().loadRefresh());
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mProgressBar = getBaseActivity().getProgresBar();
    }

    @Override
    public int onCreateToolBarTitle() {
        return 0;
    }

    protected abstract BaseFeedPresenter onCreateFeedPresenter();

    @Override
    public void showRefrasheng() {
    }

    @Override
    public void hideRefrasheng() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showListProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setItems(List<BaseViewModel> items) {
        mAdapter.setItems(items);
    }

    @Override
    public void addItems(List<BaseViewModel> items) {
        mAdapter.addItems(items);
    }
}


