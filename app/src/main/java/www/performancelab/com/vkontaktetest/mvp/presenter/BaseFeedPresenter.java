package www.performancelab.com.vkontaktetest.mvp.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import www.performancelab.com.vkontaktetest.model.view.BaseViewModel;
import www.performancelab.com.vkontaktetest.mvp.view.BaseFeedView;

public abstract class BaseFeedPresenter<V extends BaseFeedView> extends MvpPresenter<V> {

    public static final int START_PAGE_SIZE = 15;
    public static final int NEXT_PAGE_SIZE = 15;

    private boolean mIsInLoading;


    @SuppressLint("CheckResult")
    public void loadDate(ProgressType progressType, int offset, int count){
        if (mIsInLoading){
            return;
        }
        mIsInLoading = true;

        onCreateLoadDateObservable(count, offset)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(dosposable -> {
                    onLoadStart(progressType);
                })
                .doFinally(() -> {
                    onLoadingFinish(progressType);
                })
                .subscribe(repositories -> {
                    onLoadingSuccess(progressType, repositories);
                }, error -> {
                    onLoadingFauled(error);
                });
    }

    public abstract Observable<BaseViewModel> onCreateLoadDateObservable(int count, int offset);

    public enum ProgressType{
        Refreshing, ListProgress, Paging
    }

    public void showProgress(ProgressType progressType){
        switch (progressType){
            case Refreshing:
                getViewState().showRefrasheng();
                break;
            case ListProgress:
                getViewState().showListProgress();
                break;
        }
    }
    public void hideProgress(ProgressType progressType){
        switch (progressType){
            case Refreshing:
                getViewState().hideRefrasheng();
                break;
            case ListProgress:
                getViewState().hideListProgress();
                break;
        }
    }

    public void loadStart(){
        loadDate(ProgressType.ListProgress, 0 ,START_PAGE_SIZE);
    }

    public void loadNext(int offset){
        loadDate(ProgressType.Paging, offset, NEXT_PAGE_SIZE);
    }

    public void loadRefresh(){
        loadDate(ProgressType.Refreshing, 0, START_PAGE_SIZE);
    }

    public void onLoadStart(ProgressType progressType){
        showProgress(progressType);
    }

    public void onLoadingFinish(ProgressType progressType){
        mIsInLoading = false;
        hideProgress(progressType);
    }

    public void onLoadingFauled(Throwable throwable){
        getViewState().showError(throwable.getMessage());
    }

    public void onLoadingSuccess(ProgressType progressType, List<BaseViewModel> item){
        if (progressType == ProgressType.Paging){
            getViewState().addItems(item);
        } else {
            getViewState().setItems(item);
        }
    }
}