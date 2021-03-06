package www.performancelab.com.vkontaktetest.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import www.performancelab.com.vkontaktetest.ui.activity.BaseActivity;

public abstract class BaseFragment extends MvpAppCompatFragment {

    @LayoutRes
    protected abstract int getMainContentLayout();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getMainContentLayout(), container, false);
    }

    public String createToolbarTitle(Context context){
        return context.getString(onCreateToolBarTitle());
    }

    @StringRes
    public abstract int onCreateToolBarTitle();

    public BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }
}
