package www.performancelab.com.vkontaktetest;

import android.app.Application;

import com.vk.sdk.VKSdk;

import io.realm.Realm;
import io.realm.RealmConfiguration;
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

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void initComponent(){
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getsApplicationComponent(){
        return sApplicationComponent;
    }
}
