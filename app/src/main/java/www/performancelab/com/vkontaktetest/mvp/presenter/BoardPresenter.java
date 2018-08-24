package www.performancelab.com.vkontaktetest.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.consts.ApiConstants;
import www.performancelab.com.vkontaktetest.model.Member;
import www.performancelab.com.vkontaktetest.model.Topic;
import www.performancelab.com.vkontaktetest.model.view.BaseViewModel;
import www.performancelab.com.vkontaktetest.model.view.TopicViewModel;
import www.performancelab.com.vkontaktetest.mvp.view.BaseFeedView;
import www.performancelab.com.vkontaktetest.rest.api.BoardApi;
import www.performancelab.com.vkontaktetest.rest.model.request.BoardGetTopicsRequestModel;

import static io.realm.Realm.getDefaultInstance;

@InjectViewState
public class BoardPresenter extends BaseFeedPresenter<BaseFeedView>{

    @Inject
    BoardApi mBoardApi;

    public BoardPresenter() {
        MyApplication.getsApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mBoardApi.getTopics(new BoardGetTopicsRequestModel(
                ApiConstants.MY_GROUP_ID, count, offset).toMap())
                .flatMap(baseItemResponseFull -> Observable.fromIterable(baseItemResponseFull.response.getItems()))
                .doOnNext(topic -> topic.setGroupId(ApiConstants.MY_GROUP_ID))
                .doOnNext(this::saveToDb)
                .map(TopicViewModel::new);
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .map(TopicViewModel::new);
    }

    public Callable<List<Topic>> getListFromRealmCallable() {
        return () -> {
            String[] sortFields = {Member.ID};
            Sort[] sortOrder = {Sort.DESCENDING};

            Realm realm = getDefaultInstance();
            RealmResults<Topic> results = realm.where(Topic.class)
                    .equalTo("groupId", ApiConstants.MY_GROUP_ID)
                    .sort(sortFields, sortOrder)
                    .findAll();

            return realm.copyFromRealm(results);
        };
    }
}
