package mx.com.elektra.bancadigital.elektra.business.login;

import io.reactivex.Observable;
import mx.com.elektra.bancadigital.elektra.api.request.LogInRequest;
import mx.com.elektra.bancadigital.elektra.api.response.LogInResponse;

public class LoginInteractorImpl implements LogInContract.Interactor {
    public LogInContract.Repository repository;

    public LoginInteractorImpl(LogInContract.Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<LogInResponse> signIn(LogInRequest loginRequest) {
        return repository.signIn(loginRequest);
    }
}
