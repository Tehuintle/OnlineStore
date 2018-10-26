package mx.com.elektra.bancadigital.elektra.api.response;

import com.google.gson.annotations.SerializedName;

public class LogInResponse {
    @SerializedName("estado")
    private int estado;
    @SerializedName("Usuario")
    private String usuario;
    @SerializedName("Nombre")
    private String nombre;
    @SerializedName("APaterno")
    private String aPaterno;
    @SerializedName("AMaterno")
    private String aMaterno;
    @SerializedName("Genero")
    private String genero;
    @SerializedName("Token")
    private String token;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setEstado(int estado){
        this.estado = estado;
    }

    public int getEstado(){
        return estado;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setAPaterno(String aPaterno){
        this.aPaterno = aPaterno;
    }

    public String getAPaterno(){
        return aPaterno;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getGenero(){
        return genero;
    }

    public void setAMaterno(String aMaterno){
        this.aMaterno = aMaterno;
    }

    public String getAMaterno(){
        return aMaterno;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

}
