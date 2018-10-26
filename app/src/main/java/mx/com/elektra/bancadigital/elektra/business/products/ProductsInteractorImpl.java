package mx.com.elektra.bancadigital.elektra.business.products;

import io.reactivex.Observable;
import mx.com.elektra.bancadigital.elektra.api.response.ProductsResponse;

public class ProductsInteractorImpl implements ProductsContract.Interactor {

    private ProductsContract.Repository repository;

    public ProductsInteractorImpl(ProductsContract.Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ProductsResponse> getProductos(String token) {
        return repository.getProductos(token);
    }
}
