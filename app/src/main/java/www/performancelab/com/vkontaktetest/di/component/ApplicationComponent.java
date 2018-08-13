package www.performancelab.com.vkontaktetest.di.component;

import javax.inject.Singleton;

import dagger.Component;
import www.performancelab.com.vkontaktetest.di.module.ApplicationModule;
import www.performancelab.com.vkontaktetest.di.module.ManagerModule;
import www.performancelab.com.vkontaktetest.di.module.RestModule;
import www.performancelab.com.vkontaktetest.ui.activity.BaseActivity;
import www.performancelab.com.vkontaktetest.ui.activity.MainActivity;
import www.performancelab.com.vkontaktetest.ui.fragment.NewsFeedFragment;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activitys
    void inject (BaseActivity activity);
    void inject (MainActivity activity);

    //fragment
    void inject(NewsFeedFragment fragment);
}
