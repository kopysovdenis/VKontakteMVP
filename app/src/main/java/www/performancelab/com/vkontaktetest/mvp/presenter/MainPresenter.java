package www.performancelab.com.vkontaktetest.mvp.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmObject;
import www.performancelab.com.vkontaktetest.CurrentUser;
import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.common.manager.MyFragmentManager;
import www.performancelab.com.vkontaktetest.common.manager.NetworkManager;
import www.performancelab.com.vkontaktetest.model.Profile;
import www.performancelab.com.vkontaktetest.mvp.view.MineView;
import www.performancelab.com.vkontaktetest.rest.api.UsersApi;
import www.performancelab.com.vkontaktetest.rest.model.request.UsersGetRequestModel;
import www.performancelab.com.vkontaktetest.ui.fragment.BaseFragment;
import www.performancelab.com.vkontaktetest.ui.fragment.MembersFragment;
import www.performancelab.com.vkontaktetest.ui.fragment.MyPostsFragment;
import www.performancelab.com.vkontaktetest.ui.fragment.NewsFeedFragment;

@InjectViewState
public class MainPresenter extends MvpPresenter<MineView> {

    @Inject
    UsersApi mUserApi;

    @Inject
    NetworkManager mNetworkManager;

    @Inject
    MyFragmentManager myFragmentManager;

    public void checkAuth(){
        if (!CurrentUser.isAuthorized()){
            getViewState().startSignIn();
        }else {
            getCurrentUser();
            getViewState().signedIn();
        }

    }

    public MainPresenter(){
        MyApplication.getsApplicationComponent().inject(this);
    }

    public Observable<Profile> getProfileFromNetwork() {
        return mUserApi.get(new UsersGetRequestModel(CurrentUser.getId()).toMap())
                .flatMap(listFull -> Observable.fromIterable(listFull.response))
                .doOnNext(this::saveToDb);
    }

    private Observable<Profile> getProfileFromDb() {
        return Observable.fromCallable(getListFromRealmCallable());
    }

    public void saveToDb(RealmObject item) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(item));
    }

    public Callable<Profile> getListFromRealmCallable() {
        return () -> {
            Realm realm = Realm.getDefaultInstance();
            Profile realmResults = realm.where(Profile.class)
                    .equalTo("id", Integer.parseInt(CurrentUser.getId()))
                    .findFirst();
            assert realmResults != null;
            return realm.copyFromRealm(realmResults);
        };
    }

    @SuppressLint("CheckResult")
    private void getCurrentUser() {
        mNetworkManager.getNetworkObservable()
                .flatMap(aBoolean -> {
                    if (!CurrentUser.isAuthorized()){
                        getViewState().startSignIn();
                    }
                    return aBoolean
                            ?getProfileFromNetwork()
                            :getProfileFromDb();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(profile -> {
                    getViewState().showCurrentUser(profile);
                }, Throwable::printStackTrace);
    }

    public void drawerItemClick(int id){
        BaseFragment fragment = null;

        switch (id){
            case 1:
                fragment = new NewsFeedFragment();
                break;
            case 2:
                fragment = new MyPostsFragment();
                break;

            case 4:
                fragment = new MembersFragment();
                break;
        }

        if (fragment != null && !myFragmentManager.isAlreadyContains(fragment)){
            getViewState().showFragmentFromDrawer(fragment);
        }
    }
}
