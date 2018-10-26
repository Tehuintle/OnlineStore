package mx.com.elektra.bancadigital.elektra.core;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.com.elektra.bancadigital.elektra.core.content.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class CoreModule {
    private Fragment fragment;
    private Activity activity;
    private Context context;

    public CoreModule(Fragment fragment) {
        this.fragment = fragment;
        this.context = this.fragment.getActivity().getApplicationContext();
    }

    public CoreModule(Activity activity) {
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    @Provides
    @Singleton
    Activity providesActivity(){
        return this.activity;
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
