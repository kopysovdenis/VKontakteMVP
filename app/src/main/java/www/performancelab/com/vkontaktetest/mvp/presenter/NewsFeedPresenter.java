package www.performancelab.com.vkontaktetest.mvp.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.common.utils.VkListHelper;
import www.performancelab.com.vkontaktetest.model.view.BaseViewModel;
import www.performancelab.com.vkontaktetest.model.view.NewsItemBodyViewModel;
import www.performancelab.com.vkontaktetest.model.view.NewsItemHeaderViewModel;
import www.performancelab.com.vkontaktetest.mvp.view.BaseFeedView;
import www.performancelab.com.vkontaktetest.rest.api.WallApi;
import www.performancelab.com.vkontaktetest.rest.model.request.WallGetRequestModel;

@InjectViewState
public class NewsFeedPresenter extends BaseFeedPresenter<BaseFeedView>{

    @Inject
    WallApi mWallApi;

    public NewsFeedPresenter(){
        MyApplication.getsApplicationComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @Override
    public Observable<BaseViewModel> onCreateLoadDateObservable(int count, int offset) {
        return mWallApi.get(new WallGetRequestModel(-86529522).toMap())
                .flatMap(full -> Observable.fromIterable(VkListHelper.getWallList(full.response)))
                .flatMap(wallItem -> {
                    List<BaseViewModel> baseItem = new ArrayList<>();

                    baseItem.add(new NewsItemHeaderViewModel(wallItem));
                    baseItem.add(new NewsItemBodyViewModel(wallItem));
                    baseItem.add(new NewsItemHeaderViewModel(wallItem));

                    return Observable.fromIterable(baseItem);
                });
    }
}
