package www.performancelab.com.vkontaktetest.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;

import java.util.zip.Inflater;

import javax.inject.Inject;

import www.performancelab.com.vkontaktetest.MyApplication;
import www.performancelab.com.vkontaktetest.R;
import www.performancelab.com.vkontaktetest.common.manager.MyFragmentManager;
import www.performancelab.com.vkontaktetest.ui.fragment.BaseFragment;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    MyFragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getsApplicationComponent().inject(this);
        setContentView(R.layout.activity_base);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    public void fragmentoOfScreen(BaseFragment fragment){
        setToolBarTitle(fragment.createToolbarTitle(this));
    }

    public void setToolBarTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    public void setContent (BaseFragment fragment){
        mFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    public void  addContent (BaseFragment fragment){
        mFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    public boolean removeCurrentFragment(){
        return mFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment){
        return mFragmentManager.removFragment(this, fragment);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }
}
