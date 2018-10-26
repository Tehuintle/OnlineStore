package mx.com.elektra.bancadigital.elektra.business.login;

import io.reactivex.Observable;
import mx.com.elektra.bancadigital.elektra.api.UserEndPoint;
import mx.com.elektra.bancadigital.elektra.api.request.LogInRequest;
import mx.com.elektra.bancadigital.elektra.api.response.LogInResponse;
import retrofit2.Retrofit;

public class LoginRepositoryImpl implements LogInContract.Repository {
    private Retrofit retrofit;

    public LoginRepositoryImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Observable<LogInResponse> signIn(LogInRequest loginRequest) {
        return retrofit.create(UserEndPoint.class).attemptLogin(loginRequest);
    }
}
