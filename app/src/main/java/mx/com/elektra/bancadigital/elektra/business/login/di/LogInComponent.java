package mx.com.elektra.bancadigital.elektra.business.login.di;

import javax.inject.Singleton;

import dagger.Component;
import mx.com.elektra.bancadigital.elektra.business.login.LogInContract;
import mx.com.elektra.bancadigital.elektra.core.CoreModule;

@Singleton
@Component(modules = {LogInModule.class, CoreModule.class})
public interface LogInComponent {
    LogInContract.Presenter getLogInPresenter();
}
