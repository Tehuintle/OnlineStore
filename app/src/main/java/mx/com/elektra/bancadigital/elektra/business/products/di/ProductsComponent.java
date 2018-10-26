package mx.com.elektra.bancadigital.elektra.business.products.di;

import javax.inject.Singleton;

import dagger.Component;
import mx.com.elektra.bancadigital.elektra.business.products.ProductsContract;
import mx.com.elektra.bancadigital.elektra.core.CoreModule;

@Singleton
@Component(modules = {ProductsModule.class, CoreModule.class})
public interface ProductsComponent {
    ProductsContract.Presenter getProductsPresenter();
}
