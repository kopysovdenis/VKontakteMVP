package www.performancelab.com.vkontaktetest.mvp.view;

import com.arellomobile.mvp.MvpView;

import www.performancelab.com.vkontaktetest.model.Profile;
import www.performancelab.com.vkontaktetest.ui.fragment.BaseFragment;

public interface MineView extends MvpView {
    void startSignIn();
    void signedIn();
    void showCurrentUser(Profile profile);
    void showFragmentFromDrawer(BaseFragment baseFragment);
}
