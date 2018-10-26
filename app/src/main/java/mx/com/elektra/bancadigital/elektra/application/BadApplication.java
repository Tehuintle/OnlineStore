package mx.com.elektra.bancadigital.elektra.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import mx.com.elektra.bancadigital.elektra.business.login.LogInContract;
import mx.com.elektra.bancadigital.elektra.business.login.di.DaggerLogInComponent;
import mx.com.elektra.bancadigital.elektra.business.login.view.LogInActivity;
import mx.com.elektra.bancadigital.elektra.business.login.di.LogInComponent;
import mx.com.elektra.bancadigital.elektra.business.login.di.LogInModule;
import mx.com.elektra.bancadigital.elektra.business.products.ProductsContract;
import mx.com.elektra.bancadigital.elektra.business.products.di.DaggerProductsComponent;
import mx.com.elektra.bancadigital.elektra.business.products.di.ProductsComponent;
import mx.com.elektra.bancadigital.elektra.business.products.di.ProductsModule;
import mx.com.elektra.bancadigital.elektra.business.products.view.ProductsActivity;
import mx.com.elektra.bancadigital.elektra.core.CoreModule;

public class BadApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       
        initRealm();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("Elektra")
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    public LogInComponent getLogInComponent(LogInActivity activity, LogInContract.View view){
        return DaggerLogInComponent.builder()
                .coreModule(new CoreModule(activity))
                .logInModule(new LogInModule(view))
                .build();
    }

    public ProductsComponent getProductsComponent(ProductsActivity activity, ProductsContract.View view){
        return DaggerProductsComponent.builder()
                .coreModule(new CoreModule(activity))
                .productsModule(new ProductsModule(view))
                .build();
    }

}
