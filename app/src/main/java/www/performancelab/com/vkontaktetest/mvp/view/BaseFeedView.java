package www.performancelab.com.vkontaktetest.mvp.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import www.performancelab.com.vkontaktetest.model.view.BaseViewModel;

public interface BaseFeedView extends MvpView {

    void showRefrasheng();
    void hideRefrasheng();

    void showListProgress();
    void hideListProgress();

    void showError(String message);

    void setItems(List<BaseViewModel> items);
    void addItems(List<BaseViewModel> items);
}
