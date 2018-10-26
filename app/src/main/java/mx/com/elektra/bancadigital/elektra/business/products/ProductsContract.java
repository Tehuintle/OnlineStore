package mx.com.elektra.bancadigital.elektra.business.products;

import java.util.List;

import io.reactivex.Observable;
import mx.com.elektra.bancadigital.elektra.api.response.ProductsItem;
import mx.com.elektra.bancadigital.elektra.api.response.ProductsResponse;

public interface ProductsContract {
    interface View {
        void setProductsList(List<ProductsItem> productosItems);
        void setError(String error);
    }

    interface Presenter {
        void attemptGetProducts();
        void unsubscribeRx();
    }

    interface Interactor{
        Observable<ProductsResponse> getProductos(String authorization);
    }

    interface Repository {
        Observable<ProductsResponse> getProductos(String authorization);
    }

}
