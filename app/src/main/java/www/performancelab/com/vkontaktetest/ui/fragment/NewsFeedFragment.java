package www.performancelab.com.vkontaktetest.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.common.BaseAdapter;
import www.performancelab.com.vkontaktetest.common.utils.VkListHelper;
import www.performancelab.com.vkontaktetest.model.WallItem;
import www.performancelab.com.vkontaktetest.model.view.BaseViewModel;
import www.performancelab.com.vkontaktetest.model.view.NewsItemBodyViewModel;
import www.performancelab.com.vkontaktetest.model.view.NewsItemFooterViewModel;
import www.performancelab.com.vkontaktetest.model.view.NewsItemHeaderViewModel;
import www.performancelab.com.vkontaktetest.rest.api.WallApi;
import www.performancelab.com.vkontaktetest.rest.model.request.WallGetRequestModel;
import www.performancelab.com.vkontaktetest.rest.model.response.WallGetResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;



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

        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {
                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem item: wallItems){
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsItemBodyViewModel(item));
                    list.add(new NewsItemFooterViewModel(item));
                }

                mBaseAdapter.addItems(list);

                Toast.makeText(getActivity(), "Like: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }



    @Override
    public int onCreateToolBarTitle() {
        return R.string.screen_name_news;
    }


}
