package www.performancelab.com.vkontaktetest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import www.performancelab.com.vkontaktetest.CurrecnUser;
import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.consts.ApiConstants;
import www.performancelab.com.vkontaktetest.mvp.presenter.MainPresenter;
import www.performancelab.com.vkontaktetest.mvp.view.MineView;
import www.performancelab.com.vkontaktetest.ui.fragment.NewsFeedFragment;

public class MainActivity extends BaseActivity implements MineView {

    @InjectPresenter
    MainPresenter mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getsApplicationComponent().inject(this);

        mPresent.checkAuth();
        }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void startSignIn() {
        VKSdk.login(this, ApiConstants.DEFAULT_LOGIN_SCOPE);
    }

    @Override
    public void signedIn() {
        Toast.makeText(this,"Current user id: " + CurrecnUser.getId(), Toast.LENGTH_LONG).show();
        setContent(new NewsFeedFragment());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
                @Override
                public void onResult(VKAccessToken res) {
                    mPresent.checkAuth();
                }

                @Override
                public void onError(VKError error) {
                }
            })) {
            }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
