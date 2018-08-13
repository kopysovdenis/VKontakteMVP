package www.performancelab.com.vkontaktetest;

import android.app.Application;
import android.content.Context;

import com.vk.sdk.VKSdk;

import www.performancelab.com.vkontaktetest.Const.ApiConstants;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
