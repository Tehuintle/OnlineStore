package mx.com.elektra.bancadigital.elektra.business.products.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.com.elektra.bancadigital.elektra.R;
import mx.com.elektra.bancadigital.elektra.api.response.ProductsItem;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ViewHolder> {

    private List<ProductsItem> productosItems;
    private Context context;
    private OnProductClickListener listener;


    public AdapterProducts(List<ProductsItem> productosItems, Context context, OnProductClickListener listener) {
        this.productosItems = productosItems;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_products, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsItem productosItem = productosItems.get(position);
        Glide.with(context).load(productosItem.getUrlImagen()).into(holder.imvProduct);
        holder.txtvDetail.setText(productosItem.getStatusOferta());
        holder.txtvName.setText(productosItem.getNombre());
        holder.txtvQuantity.setText(productosItem.getStockFinal());
        holder.txtvPrice.setText(productosItem.getPrecioVenta());
        holder.btnShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.productClicked(productosItem);
            }
        });
    }

    public interface OnProductClickListener{
        void productClicked(ProductsItem productosItem);
    }

    @Override
    public int getItemCount() {
        return productosItems.size();
    }

    public void updateProductsList(List<ProductsItem> productosItems){
        this.productosItems = productosItems;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imvProduct)
        ImageView imvProduct;
        @BindView(R.id.txtvDetail)
        TextView txtvDetail;
        @BindView(R.id.txtvName)
        TextView txtvName;
        @BindView(R.id.txtvQuantity)
        TextView txtvQuantity;
        @BindView(R.id.txtvPrice)
        TextView txtvPrice;
        @BindView(R.id.btnShowDetail)
        LinearLayout btnShowDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

