package www.performancelab.com.vkontaktetest.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.ButterKnife;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.mvp.presenter.BaseFeedPresenter;
import www.performancelab.com.vkontaktetest.mvp.presenter.BoardPresenter;

public class BoardFragment extends BaseFeedFragment {

    @InjectPresenter
    BoardPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }

    @Override
    public int onCreateToolBarTitle() {
        return R.string.screen_name_topics;
    }
}
