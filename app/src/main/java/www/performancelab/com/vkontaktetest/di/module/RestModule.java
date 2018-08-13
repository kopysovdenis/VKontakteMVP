package www.performancelab.com.vkontaktetest.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import www.performancelab.com.vkontaktetest.rest.RestClient;
import www.performancelab.com.vkontaktetest.rest.api.WallApi;

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

    @Singleton
    @Provides
    public WallApi provideWallApi(){
        return mRestClient.createService(WallApi.class);
    }
}
