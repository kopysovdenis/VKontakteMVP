package www.performancelab.com.vkontaktetest.di.module;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application mAplication;

    public ApplicationModule (Application application){
        mAplication = application;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return mAplication;
    }

    @Singleton
    @Provides
    Typeface provideGoogleTypeface(Context context){
        return Typeface.createFromAsset(context.getAssets(), "MaterialIcons-Regular.ttf");
    }
}
