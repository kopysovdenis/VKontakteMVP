package www.performancelab.com.vkontaktetest;

import android.app.Application;

import com.vk.sdk.VKSdk;

import dagger.internal.DaggerCollections;
import www.performancelab.com.vkontaktetest.di.component.ApplicationComponent;
import www.performancelab.com.vkontaktetest.di.component.DaggerApplicationComponent;
import www.performancelab.com.vkontaktetest.di.module.ApplicationModule;

public class MyApplication extends Application {

    private  static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent(){
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getsApplicationComponent(){
        return sApplicationComponent;
    }
}
