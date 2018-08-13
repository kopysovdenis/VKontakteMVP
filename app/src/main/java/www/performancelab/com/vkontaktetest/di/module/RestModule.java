package www.performancelab.com.vkontaktetest.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import www.performancelab.com.vkontaktetest.rest.RestClient;

@Module
public class RestModule {

    private RestClient mRestClient;

    public RestModule(){
        mRestClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient(){
        return mRestClient;
    }
}
