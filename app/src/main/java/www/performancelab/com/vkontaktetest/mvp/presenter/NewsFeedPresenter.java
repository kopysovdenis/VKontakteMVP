package www.performancelab.com.vkontaktetest.mvp.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import www.performancelab.com.vkontaktetest.CurrentUser;
import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.common.utils.VkListHelper;
import www.performancelab.com.vkontaktetest.consts.ApiConstants;
import www.performancelab.com.vkontaktetest.model.WallItem;
import www.performancelab.com.vkontaktetest.model.view.BaseViewModel;
import www.performancelab.com.vkontaktetest.model.view.NewsItemBodyViewModel;
import www.performancelab.com.vkontaktetest.model.view.NewsItemFooterViewModel;
import www.performancelab.com.vkontaktetest.model.view.NewsItemHeaderViewModel;
import www.performancelab.com.vkontaktetest.mvp.view.BaseFeedView;
import www.performancelab.com.vkontaktetest.rest.api.WallApi;
import www.performancelab.com.vkontaktetest.rest.model.request.WallGetRequestModel;

@InjectViewState
public class NewsFeedPresenter extends BaseFeedPresenter<BaseFeedView>{

    @Inject
    WallApi mWallApi;

    private boolean enableIdFiltering = false;

    public NewsFeedPresenter(){
        MyApplication.getsApplicationComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mWallApi.get(new WallGetRequestModel(ApiConstants.MY_GROUP_ID, count, offset).toMap())
                .flatMap(full -> Observable.fromIterable(VkListHelper.getWallList(full.response)))
                .compose(applyFilter())
                .doOnNext(this::saveToDb)
                .flatMap(wallItem -> {
                    List<BaseViewModel> baseItem = new ArrayList<>();

                    baseItem.add(new NewsItemHeaderViewModel(wallItem));
                    baseItem.add(new NewsItemBodyViewModel(wallItem));
                    baseItem.add(new NewsItemFooterViewModel(wallItem));

                    return Observable.fromIterable(baseItem);
                });
    }



    protected ObservableTransformer<WallItem, WallItem> applyFilter(){
        if (enableIdFiltering && CurrentUser.getId() != null){
            return baseItemObservable -> baseItemObservable
                    .filter(wallItem -> CurrentUser.getId()
                            .equals(String.valueOf(wallItem.getFromId())));
        } else {
            return baseItemObservable -> baseItemObservable;
        }
    }

    public void setEnableIdFiltering(boolean enableIdFiltering) {
        this.enableIdFiltering = enableIdFiltering;
    }

    public Callable<List<WallItem>> getListFromRealmCallable() {
        return () -> {
            String[] sortFields = {"date"};
            Sort[] sortOrder = {Sort.DESCENDING};
            Realm realm = Realm.getDefaultInstance();
            RealmResults<WallItem> realmResults = realm.where(WallItem.class)
                    .sort(sortFields, sortOrder)
                    .findAll();
            return realm.copyFromRealm(realmResults);
        };
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .compose(applyFilter())
                .flatMap(wallItem -> Observable.fromIterable(parsePojoModel(wallItem)));
    }


    private List<BaseViewModel> parsePojoModel(WallItem wallItem) {
        List<BaseViewModel> baseItems = new ArrayList<>();
        baseItems.add(new NewsItemHeaderViewModel(wallItem));
        baseItems.add(new NewsItemBodyViewModel(wallItem));
        baseItems.add(new NewsItemFooterViewModel(wallItem));
        return baseItems;
    }
}
