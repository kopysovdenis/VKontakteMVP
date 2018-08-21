package www.performancelab.com.vkontaktetest.di.component;

import javax.inject.Singleton;

import dagger.Component;
import www.performancelab.com.vkontaktetest.common.manager.NetworkManager;
import www.performancelab.com.vkontaktetest.di.module.ApplicationModule;
import www.performancelab.com.vkontaktetest.di.module.ManagerModule;
import www.performancelab.com.vkontaktetest.di.module.RestModule;
import www.performancelab.com.vkontaktetest.mvp.presenter.MainPresenter;
import www.performancelab.com.vkontaktetest.mvp.presenter.MembersPresenter;
import www.performancelab.com.vkontaktetest.mvp.presenter.NewsFeedPresenter;
import www.performancelab.com.vkontaktetest.ui.activity.BaseActivity;
import www.performancelab.com.vkontaktetest.ui.activity.MainActivity;
import www.performancelab.com.vkontaktetest.ui.fragment.NewsFeedFragment;
import www.performancelab.com.vkontaktetest.ui.holder.NewsItebBodyHolder;
import www.performancelab.com.vkontaktetest.ui.holder.NewsItemFooterHolder;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {



    //activitys
    void inject (BaseActivity activity);
    void inject (MainActivity activity);

    //fragment
    void inject(NewsFeedFragment fragment);

    //holder
    void inject(NewsItebBodyHolder holder);
    void inject(NewsItemFooterHolder holder);

    //presenter
    void inject(NewsFeedPresenter presenter);
    void inject(MainPresenter presenter);
    void inject(MembersPresenter presenter);

    //manager
    void inject(NetworkManager manager);
}
