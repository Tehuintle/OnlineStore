package mx.com.elektra.bancadigital.elektra.business.products;

import io.reactivex.Observable;
import mx.com.elektra.bancadigital.elektra.api.UserEndPoint;
import mx.com.elektra.bancadigital.elektra.api.response.ProductsResponse;
import retrofit2.Retrofit;

public class ProductsRepositoryImpl implements ProductsContract.Repository {
    private Retrofit retrofit;

    public ProductsRepositoryImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Observable<ProductsResponse> getProductos(String token) {
        return retrofit.create(UserEndPoint.class).getProducts(token);
    }
}
