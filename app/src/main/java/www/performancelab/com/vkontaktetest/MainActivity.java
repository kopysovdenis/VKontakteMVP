package www.performancelab.com.vkontaktetest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import www.performancelab.com.vkontaktetest.Const.ApiConstants;
import www.performancelab.com.vkontaktetest.mvp.presenter.MainPresenter;
import www.performancelab.com.vkontaktetest.mvp.view.MineView;

public class MainActivity extends MvpAppCompatActivity implements MineView {

    @InjectPresenter
    MainPresenter mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresent.checkAuth();
        }

    @Override
    public void startSignIn() {
        VKSdk.login(this, ApiConstants.DEFAULT_LOGIN_SCOPE);
    }

    @Override
    public void signedIn() {
        Toast.makeText(this,"Current user id: " + CurrecnUser.getId(), Toast.LENGTH_LONG).show();
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
