package mx.com.elektra.bancadigital.elektra.business.login;

import io.reactivex.Observable;
import mx.com.elektra.bancadigital.elektra.api.request.LogInRequest;
import mx.com.elektra.bancadigital.elektra.api.response.LogInResponse;

public interface LogInContract {
    interface View {
        void setloginSuccess(LogInResponse userProfile);
        void setError(String message);
    }

    interface Presenter {
        void attemptLogIn(String user, String password);
        void unsubscribeRx();
    }

    interface Interactor {
        Observable<LogInResponse> signIn(LogInRequest loginRequest);
    }

    interface Repository {
        Observable<LogInResponse> signIn(LogInRequest loginRequest);
    }
}
