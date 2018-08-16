package www.performancelab.com.vkontaktetest.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.common.BaseAdapter;

public class BaseFeedFragment extends BaseFragment {

    RecyclerView mRecyclerView;
    BaseAdapter mBaseAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }




    private void setUpRecyclerView(View rootView){
        mRecyclerView = rootView.findViewById(R.id.rv_List);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter(RecyclerView recyclerView){
        mBaseAdapter = new BaseAdapter();

        recyclerView.setAdapter(mBaseAdapter);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolBarTitle() {
        return 0;
    }
}
