package www.performancelab.com.vkontaktetest.ui.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.mvp.presenter.BaseFeedPresenter;
import www.performancelab.com.vkontaktetest.mvp.presenter.NewsFeedPresenter;
import www.performancelab.com.vkontaktetest.rest.api.WallApi;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFeedFragment{

    @Inject
    WallApi mWallApi;

    @InjectPresenter
    NewsFeedPresenter mPresenter;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getsApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public int onCreateToolBarTitle() {
        return R.string.screen_name_news;
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }
}
