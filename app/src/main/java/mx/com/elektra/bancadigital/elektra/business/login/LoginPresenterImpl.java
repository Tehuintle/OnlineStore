package mx.com.elektra.bancadigital.elektra.business.login;

import android.app.Activity;
import android.content.Context;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import mx.com.elektra.bancadigital.elektra.R;
import mx.com.elektra.bancadigital.elektra.api.request.LogInRequest;
import mx.com.elektra.bancadigital.elektra.api.response.LogInResponse;
import mx.com.elektra.bancadigital.elektra.core.util.ValidateMail;
import timber.log.Timber;

public class LoginPresenterImpl implements LogInContract.Presenter {

    private LogInContract.View view;
    private LogInContract.Interactor interactor;
    private Disposable subscription;
    private Context context;

    public LoginPresenterImpl(LogInContract.View view, LogInContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
        this.context = (Activity) this.view;
    }

    @Override
    public void attemptLogIn(String user, String password) {
        if (view != null){
            if(user.equals("")){
                view.setError(context.getString(R.string.gmail));
                return;
            }
            if(password.equals("")){
                view.setError(context.getString(R.string.password));
                return;
            }
            if(!ValidateMail.isRightEmailFormat(user)){
                view.setError(context.getString(R.string.gmail_invalidate));
                return;
            }
            subscription = interactor.signIn(new LogInRequest(user, password))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<LogInResponse>() {
                        @Override
                        public void onNext(LogInResponse loginResponse) {
                            if(loginResponse.getEstado() == 200){
                                view.setloginSuccess(loginResponse);
                            } else {
                                view.setError(context.getString(R.string.message_unavailable_network_connection));
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Timber.e(e.getMessage());
                            view.setError(context.getString(R.string.message_unavailable_network_connection));
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            Timber.e("Vista no se encontro");
        }
    }

    @Override
    public void unsubscribeRx(){
        if (subscription!= null && !subscription.isDisposed()){
            subscription.dispose();
            if (view != null) {
                view = null;
            }
        }
    }
}
