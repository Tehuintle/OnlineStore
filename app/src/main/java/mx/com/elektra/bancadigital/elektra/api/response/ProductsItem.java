package mx.com.elektra.bancadigital.elektra.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductsItem implements Serializable {

    @SerializedName("idProducto")
    private String idProducto;

    @SerializedName("Nombre")
    private String nombre;

    @SerializedName("Descripcion")
    private String descripcion;

    @SerializedName("PrecioVenta")
    private String precioVenta;

    @SerializedName("PrecioCompra")
    private String precioCompra;

    @SerializedName("StockInicial")
    private String stockInicial;

    @SerializedName("StockFinal")
    private String stockFinal;

    @SerializedName("Url_Imagen")
    private String urlImagen;

    @SerializedName("Fecha_Creacion_Modificacion")
    private String fechaCreacionModificacion;

    @SerializedName("statusOferta")
    private String statusOferta;

    @SerializedName("idCategoria")
    private String idCategoria;

    @SerializedName("idProveedor")
    private String idProveedor;


    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getStockInicial() {
        return stockInicial;
    }

    public void setStockInicial(String stockInicial) {
        this.stockInicial = stockInicial;
    }

    public String getStockFinal() {
        return stockFinal;
    }

    public void setStockFinal(String stockFinal) {
        this.stockFinal = stockFinal;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getFechaCreacionModificacion() {
        return fechaCreacionModificacion;
    }

    public void setFechaCreacionModificacion(String fechaCreacionModificacion) {
        this.fechaCreacionModificacion = fechaCreacionModificacion;
    }

    public String getStatusOferta() {
        return statusOferta;
    }

    public void setStatusOferta(String statusOferta) {
        this.statusOferta = statusOferta;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }
}
