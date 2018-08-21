package www.performancelab.com.vkontaktetest.ui.fragment;

import android.os.Bundle;

import www.performancelab.com.vkontaktetest.R;

public class MyPostsFragment extends NewsFeedFragment {
    public MyPostsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.setEnableIdFiltering(true);
    }

    @Override
    public int onCreateToolBarTitle() {
        return R.string.screen_name_my_posts;
    }
}
