package mx.com.elektra.bancadigital.elektra.business.products;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import mx.com.elektra.bancadigital.elektra.R;
import mx.com.elektra.bancadigital.elektra.api.response.LogInResponse;
import mx.com.elektra.bancadigital.elektra.api.response.ProductsResponse;
import mx.com.elektra.bancadigital.elektra.core.content.AppPreferences;
import timber.log.Timber;

public class ProductsPresenterImpl implements ProductsContract.Presenter {

    private ProductsContract.View view;
    private ProductsContract.Interactor interactor;
    private Context context;
    private Disposable subscription;

    public ProductsPresenterImpl(ProductsContract.View view, ProductsContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
        this.context = (Activity) this.view;
    }

    @Override
    public void attemptGetProducts() {
        if(view != null) {
            Gson gson = new Gson();
            LogInResponse loginResponse = gson.fromJson(AppPreferences.getUserObject(context), LogInResponse.class);
            subscription = interactor.getProductos(loginResponse.getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<ProductsResponse>() {
                        @Override
                        public void onNext(ProductsResponse productsResponse) {
                            if(productsResponse.getEstado() == 200){
                                view.setProductsList(productsResponse.getProductosItem());
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
            Timber.e("Vista nulo");
        }
    }

    @Override
    public void unsubscribeRx() {
        if (subscription!= null && !subscription.isDisposed()){
            subscription.dispose();
            if (view != null) {
                view = null;
            }
        }
    }
}
