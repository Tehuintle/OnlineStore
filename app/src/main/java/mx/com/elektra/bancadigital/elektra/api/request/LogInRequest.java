package mx.com.elektra.bancadigital.elektra.api.request;

import com.google.gson.annotations.SerializedName;

public class LogInRequest {

    @SerializedName("Usuario")
    private String usuario;
    @SerializedName("Password")
    private String password;

    public LogInRequest(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
