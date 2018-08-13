package www.performancelab.com.vkontaktetest.di.component;

import javax.inject.Singleton;

import dagger.Component;
import www.performancelab.com.vkontaktetest.di.module.ApplicationModule;
import www.performancelab.com.vkontaktetest.di.module.ManagerModule;
import www.performancelab.com.vkontaktetest.ui.activity.BaseActivity;
import www.performancelab.com.vkontaktetest.ui.activity.MainActivity;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class})
public interface ApplicationComponent {

    //activitys
    void inject (BaseActivity activity);
    void inject (MainActivity activity);
}
