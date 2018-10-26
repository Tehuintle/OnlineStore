package mx.com.elektra.bancadigital.elektra.business.products.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import mx.com.elektra.bancadigital.elektra.R;
import mx.com.elektra.bancadigital.elektra.api.response.ProductsItem;
import mx.com.elektra.bancadigital.elektra.application.BadApplication;
import mx.com.elektra.bancadigital.elektra.business.products.ProductsContract;
import mx.com.elektra.bancadigital.elektra.core.BaseActivity;
import mx.com.elektra.bancadigital.elektra.core.content.Constants;

public class ProductsActivity extends BaseActivity implements ProductsContract.View, AdapterProducts.OnProductClickListener {


    @BindView(R.id.recyclerView) RecyclerView rvProducts;
    private AdapterProducts adapterProducts;

    private ProductsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_products;
    }


    @Override
    public void initViews() {
        super.initViews();
        adapterProducts = new AdapterProducts(new ArrayList<ProductsItem>(), this, this);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        rvProducts.setAdapter(adapterProducts);
    }

    @Override
    public void setupInjection() {
        super.setupInjection();
        presenter = ((BadApplication) getApplication()).getProductsComponent(this,this).getProductsPresenter();
        presenter.attemptGetProducts();
    }


    @Override
    public void setProductsList(List<ProductsItem> productosItems) {
        adapterProducts.updateProductsList(productosItems);
    }

    @Override
    public void productClicked(ProductsItem productosItem) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        intent.putExtra(Constants.PRODUCT, productosItem);
        startActivity(intent);
    }

    @Override
    public void setError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribeRx();
    }
}
