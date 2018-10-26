package mx.com.elektra.bancadigital.elektra.business.products.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import mx.com.elektra.bancadigital.elektra.R;
import mx.com.elektra.bancadigital.elektra.api.response.ProductsItem;
import mx.com.elektra.bancadigital.elektra.core.BaseActivity;
import mx.com.elektra.bancadigital.elektra.core.content.Constants;

public class ProductDetailActivity extends BaseActivity {

    @BindView(R.id.txtvDetail)
    TextView txtvDetail;
    @BindView(R.id.txtvName)
    TextView txtvName;
    @BindView(R.id.txtvQuantity)
    TextView txtvQuantity;
    @BindView(R.id.txtvPrice)
    TextView txtvPrice;
    @BindView(R.id.txtvDescription)
    TextView txtvDescription;
    @BindView(R.id.app_bar_layout) AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_products;
    }


    @Override
    public void initViews() {
        super.initViews();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                double porcentage = (double) Math.abs(verticalOffset) / collapsingToolbar.getHeight();
                Log.i("PRODUCTOS", "Resultado: "+porcentage);
                if (porcentage < 0.525) {
                    collapsingToolbar.setTitle("");
                    txtvQuantity.setVisibility(View.VISIBLE);
                } else {
                    if (porcentage > 0.725) {
                        collapsingToolbar.setTitle("LAPTOP");
                        txtvQuantity.setVisibility(View.GONE);
                    }

                }
            }
        });

        final ImageView image = (ImageView) findViewById(R.id.imageProduct);
        if(getIntent() != null){
            ProductsItem productosItem = (ProductsItem) getIntent().getSerializableExtra(Constants.PRODUCT);
            Glide.with(this).load(productosItem.getUrlImagen()).into(image);
            txtvDetail.setText(productosItem.getStatusOferta());
            txtvName.setText(productosItem.getNombre());
            txtvQuantity.setText(productosItem.getStockFinal());
            txtvPrice.setText(productosItem.getPrecioVenta());
            txtvDescription.setText(productosItem.getDescripcion());
        }
    }

}
