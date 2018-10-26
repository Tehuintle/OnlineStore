package mx.com.elektra.bancadigital.elektra.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bindViews();
        initViews();
        makeLoading();
        setupInjection();
    }

    protected abstract int getLayoutId();

    public void bindViews() {
        ButterKnife.bind(this);
    }

    public void initViews(){
    }

    public void makeLoading() {
    }

    public void setupInjection() {
    }

}
