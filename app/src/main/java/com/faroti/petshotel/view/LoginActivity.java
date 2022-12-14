package com.faroti.petshotel.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.faroti.petshotel.R;
import com.faroti.petshotel.mvp.LoginMVP;
import com.faroti.petshotel.presenter.LoginPresenter;
import com.google.android.gms.common.SignInButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {

    private final static String EMAIL_KEY = "email";
    private final static String PASSWORD_KEY = "password";

    private LinearProgressIndicator piWaitingLogin;
    private ImageView ivLogo;
    private TextInputLayout tilEmail;
    private TextInputEditText etEmail;
    private TextInputLayout tilPassword;
    private TextInputEditText etPassword;

    private AppCompatButton buttonSingLogin;
    private SignInButton buttonGoogle;
    private AppCompatButton buttonRegister;

    private LoginMVP.Presenter presenter;
    private ActivityResultLauncher<Intent> gmailLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        presenter.isAuthenticated();
        initIU();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(EMAIL_KEY, etEmail.getText().toString());
        outState.putString(PASSWORD_KEY, etPassword.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        etEmail.setText(savedInstanceState.getString(EMAIL_KEY));
        etPassword.setText(savedInstanceState.getString(PASSWORD_KEY));

    }

    private void initIU() {
        piWaitingLogin = findViewById(R.id.pi_waiting_login);

        ivLogo = findViewById(R.id.logo_login);

        tilEmail = findViewById(R.id.til_email_login);
        etEmail = findViewById(R.id.et_email_login);

        tilPassword = findViewById(R.id.til_password_login);
        etPassword = findViewById(R.id.et_password_login);

        buttonSingLogin = findViewById(R.id.button_sign_in_login);
        buttonSingLogin.setOnClickListener((evt) -> presenter.loginWithEmail());

        //*buttonRegister = findViewById(R.id.register_init_login);
        //buttonRegister.setOnClickListener((evt) -> presenter.());
        buttonRegister = findViewById(R.id.register_init_login);
        buttonRegister.setOnClickListener((evt) -> goToRegister());

        buttonGoogle = findViewById(R.id.button_google_login);
        buttonGoogle.setOnClickListener((evt) -> presenter.loginWithGoogle());
        gmailLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        presenter.setGoogleData(data);
                    }else {
                        stopWaiting();
                    }
                });
    }


    @Override
    public Activity getActivity() {
        return this;
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
        tilPassword.setError(error);
        tilEmail.setError(error);
        //Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showToastError(String error) {
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

    @Override
    public void startWaiting() {
        piWaitingLogin.setVisibility(View.VISIBLE);
        buttonSingLogin.setEnabled(false);
        buttonGoogle.setEnabled(false);
    }

    @Override
    public void stopWaiting() {
        piWaitingLogin.setVisibility(View.GONE);
        buttonSingLogin.setEnabled(true);
        buttonGoogle.setEnabled(true);
    }

    @Override
    public void openGoogleSignInActivity(Intent intent) {
        gmailLauncher.launch(intent);
    }

    public void goToRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}