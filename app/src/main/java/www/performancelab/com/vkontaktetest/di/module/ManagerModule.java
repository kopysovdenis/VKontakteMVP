package www.performancelab.com.vkontaktetest.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import www.performancelab.com.vkontaktetest.common.manager.MyFragmentManager;

@Module
public class ManagerModule {

    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager(){
        return new MyFragmentManager();
    }
}
