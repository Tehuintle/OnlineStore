package mx.com.elektra.bancadigital.elektra.business.products.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.com.elektra.bancadigital.elektra.business.products.ProductsContract;
import mx.com.elektra.bancadigital.elektra.business.products.ProductsInteractorImpl;
import mx.com.elektra.bancadigital.elektra.business.products.ProductsPresenterImpl;
import mx.com.elektra.bancadigital.elektra.business.products.ProductsRepositoryImpl;
import retrofit2.Retrofit;

@Module
public class ProductsModule {
    ProductsContract.View view;

    public ProductsModule(ProductsContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    ProductsContract.View providesProductsView(){
        return view;
    }

    @Provides
    @Singleton
    ProductsContract.Presenter providesProductsPresenter(ProductsContract.View view, ProductsContract.Interactor interactor){
        return new ProductsPresenterImpl(view, interactor);
    }

    @Provides
    @Singleton
    ProductsContract.Interactor providesProductsInteractor(ProductsContract.Repository repository){
        return new ProductsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ProductsContract.Repository providesProductsRepository(Retrofit retrofit){
        return new ProductsRepositoryImpl(retrofit);
    }
}
