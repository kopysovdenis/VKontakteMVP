package www.performancelab.com.vkontaktetest.ui.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.R;
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

    @SuppressLint("CheckResult")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).flatMap(new Function<WallGetResponse, ObservableSource<WallItem>>() {
            @Override
            public ObservableSource<WallItem> apply(@NonNull WallGetResponse getWallResponse) throws Exception {
                return io.reactivex.Observable.fromIterable(VkListHelper.getWallList(getWallResponse.response));
            }
        })
                .flatMap(new Function<WallItem, ObservableSource<BaseViewModel>>() {
                    @Override
                    public ObservableSource<BaseViewModel> apply(@NonNull WallItem wallItem) throws Exception {

                        List<BaseViewModel> baseItem = new ArrayList<>();
                        baseItem.add(new NewsItemHeaderViewModel(wallItem));
                        baseItem.add(new NewsItemBodyViewModel(wallItem));
                        baseItem.add(new NewsItemFooterViewModel(wallItem));
                        return io.reactivex.Observable.fromIterable(baseItem);
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<BaseViewModel>>() {
                    @Override
                    public void accept(List<BaseViewModel> objects) throws Exception {
                        mBaseAdapter.addItems(objects);
                    }
                });
    }



    @Override
    public int onCreateToolBarTitle() {
        return R.string.screen_name_news;
    }


}
