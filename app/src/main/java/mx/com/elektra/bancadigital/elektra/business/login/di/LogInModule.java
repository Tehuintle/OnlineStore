package mx.com.elektra.bancadigital.elektra.business.login.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.com.elektra.bancadigital.elektra.business.login.LogInContract;
import mx.com.elektra.bancadigital.elektra.business.login.LoginInteractorImpl;
import mx.com.elektra.bancadigital.elektra.business.login.LoginPresenterImpl;
import mx.com.elektra.bancadigital.elektra.business.login.LoginRepositoryImpl;
import retrofit2.Retrofit;

@Module
public class LogInModule {
    private LogInContract.View view;

    public LogInModule(LogInContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LogInContract.View providesLoginView(){
        return view;
    }

    @Provides
    @Singleton
    LogInContract.Presenter providesLoginPresenter(LogInContract.View view, LogInContract.Interactor interactor){
        return new LoginPresenterImpl(view, interactor);
    }

    @Provides
    @Singleton
    LogInContract.Interactor providesLoginInteractor(LogInContract.Repository repository){
        return new LoginInteractorImpl(repository);
    }

    @Provides
    @Singleton
    LogInContract.Repository providesLoginRepository(Retrofit retrofit){
        return new LoginRepositoryImpl(retrofit);
    }
}
