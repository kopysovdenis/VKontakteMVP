package www.performancelab.com.vkontaktetest.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import www.performancelab.com.vkontaktetest.CurrecnUser;
import www.performancelab.com.vkontaktetest.mvp.view.MineView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MineView> {

    public void checkAuth(){
        if (!CurrecnUser.isAuthorized()){
            getViewState().startSignIn();
        }else {
            getViewState().signedIn();
        }

    }
}
