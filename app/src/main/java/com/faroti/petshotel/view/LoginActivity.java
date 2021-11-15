package com.faroti.petshotel.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.faroti.petshotel.R;
import com.faroti.petshotel.mvp.LoginMVP;
import com.faroti.petshotel.presenter.LoginPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {
    private ImageView ivLogo;
    private TextInputLayout tilEmail;
    private TextInputEditText etEmail;
    private TextInputLayout tilPassword;
    private TextInputEditText etPassword;

    private AppCompatButton buttonSingLogin;
    private AppCompatButton buttonFacebook;
    private AppCompatButton buttonGoogle;

    private LoginMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        initIU();
    }

    private void initIU() {
        ivLogo = findViewById(R.id.iv_logo);

        tilEmail = findViewById(R.id.til_email_login);
        etEmail = findViewById(R.id.et_email_login);

        tilPassword = findViewById(R.id.til_password_login);
        etPassword = findViewById(R.id.et_password_login);

        buttonSingLogin = findViewById(R.id.button_sign_in_login);
        buttonSingLogin.setOnClickListener((evt) -> presenter.loginWithEmail());

        buttonFacebook = findViewById(R.id.button_facebook_login);
        buttonFacebook.setOnClickListener((evt) -> presenter.loginWithFacebook());

        buttonGoogle = findViewById(R.id.button_google_login);
        buttonGoogle.setOnClickListener((evt) -> presenter.loginWithGoogle());
    }


    @Override
    public LoginMVP.LoginInfo getLoginInfo() {
        return new LoginMVP.LoginInfo(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void showEmailError(String error) {
        tilEmail.setError(error);
    }

    @Override
    public void showPasswordError(String error) {
        tilPassword.setError(error);
    }

    @Override
    public void showGeneralError(String error) {
        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearData() {
        tilEmail.setError("");
        etEmail.setText("");
        tilPassword.setError("");
        etPassword.setText("");
    }

    @Override
    public void openSearchContactActivity() {
        Intent intent = new Intent(this, SearchContact.class);
        startActivity(intent);
    }
}