package com.faroti.petshotel.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.faroti.petshotel.R;
import com.faroti.petshotel.mvp.RegisterMVP;
import com.faroti.petshotel.presenter.RegisterPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterUserActivity extends AppCompatActivity implements RegisterMVP.View {


    private ImageView logoRegister;
    private TextInputLayout tilEmail;
    private TextInputEditText EmailRegister;
    private TextInputLayout tilPassword;
    private TextInputEditText passwordRegister;

    private AppCompatButton buttonFacebook;
    private AppCompatButton buttonGoogle;
    private AppCompatButton buttonSingUpUser;

    private RegisterMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        presenter = new RegisterPresenter(this);
        initUI();
    }

    private void initUI() {
        logoRegister = findViewById(R.id.logo_register);

        tilEmail = findViewById(R.id.til_email_register);
        EmailRegister = findViewById(R.id.edit_text_email_register);
        EmailRegister.setText("example@gmail.com");

        tilPassword = findViewById(R.id.til_password_register);
        passwordRegister = findViewById(R.id.edit_text_password_register);
        passwordRegister.setText("Abcd_1234");

        buttonSingUpUser = findViewById(R.id.button_register_user);
        buttonSingUpUser.setOnClickListener((evt) -> presenter.RegisterWithEmail());

        buttonFacebook = findViewById(R.id.button_facebook_register);
        buttonFacebook.setOnClickListener((evt) -> presenter.RegisterWithFacebook());

        buttonGoogle = findViewById(R.id.button_google_register);
        buttonGoogle.setOnClickListener((evt) -> presenter.RegisterWithGoogle());
    }

    @Override
    public RegisterMVP.RegisterInfo getRegisterInfo() {
        return new RegisterMVP.RegisterInfo(EmailRegister.getText().toString(),
                                            passwordRegister.getText().toString());
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
    public void showGeneralMessage(String error) {
        Toast.makeText(RegisterUserActivity.this,error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearData() {
        tilEmail.setError("");
        EmailRegister.setText("");
        tilPassword.setError("");
        passwordRegister.setText("");
    }

    @Override
    public void openNewActivity() {
        Intent intent = new Intent(this, SearchContact.class);
        startActivity(intent);
    }
}