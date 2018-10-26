package mx.com.elektra.bancadigital.elektra.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsResponse {

    @SerializedName("estado")
    private int estado;

    @SerializedName("productos")
    private List<ProductsItem> productosItem;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<ProductsItem> getProductosItem() {
        return productosItem;
    }

    public void setProductosItem(List<ProductsItem> productosItem) {
        this.productosItem = productosItem;
    }
}
