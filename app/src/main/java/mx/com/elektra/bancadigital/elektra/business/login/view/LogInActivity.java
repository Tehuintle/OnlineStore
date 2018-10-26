package mx.com.elektra.bancadigital.elektra.business.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;
import mx.com.elektra.bancadigital.elektra.R;
import mx.com.elektra.bancadigital.elektra.api.response.LogInResponse;
import mx.com.elektra.bancadigital.elektra.application.BadApplication;
import mx.com.elektra.bancadigital.elektra.business.login.LogInContract;
import mx.com.elektra.bancadigital.elektra.business.products.view.ProductsActivity;
import mx.com.elektra.bancadigital.elektra.core.BaseActivity;
import mx.com.elektra.bancadigital.elektra.core.content.AppPreferences;


public class LogInActivity extends BaseActivity implements LogInContract.View {

    /*********************************
     *         BUTTERKNIFE           *
     *********************************/
    @BindView(R.id.et_login_usuario)
    TextInputEditText etLoginUsuario;
    @BindView(R.id.et_login_password)
    TextInputEditText etLoginPassword;
    @BindView(R.id.tv_msj_error_servidor)
    TextView tvMsjErrorServidor;


    /*********************************
     *         DAGGER INJECTS        *
     *********************************/
    LogInContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews() {
        super.initViews();
        if(AppPreferences.isLoggedIn(this)){
            initProductsActivity();
        }
    }

    private void initProductsActivity() {
        startActivity(new Intent(this, ProductsActivity.class));
        finish();
    }

    @OnClick({R.id.btn_login, R.id.btn_login_registrate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                presenter.attemptLogIn(etLoginUsuario.getText().toString(), etLoginPassword.getText().toString());
                break;
            case R.id.btn_login_registrate:
                startActivity(new Intent(this, SignUp.class));
                break;
        }
    }

    @Override
    public void setupInjection() {
        super.setupInjection();
        presenter = ((BadApplication) getApplication()).getLogInComponent(this, this).getLogInPresenter();
    }

    @Override
    public void setloginSuccess(LogInResponse loginResponse) {
        AppPreferences.saveObjectUserSession(this, new Gson().toJson(loginResponse));
        startActivity(new Intent(this, ProductsActivity.class));
        finish();
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
