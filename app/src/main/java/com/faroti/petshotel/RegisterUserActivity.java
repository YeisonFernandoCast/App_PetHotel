package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterUserActivity extends AppCompatActivity {


    ImageView logoRegister;
    TextInputLayout tilEmail;
    TextInputEditText EmailRegister;
    TextInputLayout tilPassword;
    TextInputEditText passwordRegister;

    AppCompatButton buttonFacebook;
    AppCompatButton buttonGoogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        initUI();
    }

    private void initUI() {
        logoRegister = findViewById(R.id.logoRegister);

        tilEmail = findViewById(R.id.til_email);
        EmailRegister = findViewById(R.id.editText_emailRegister);
        EmailRegister.setText("example@gmail.com");

        tilPassword = findViewById(R.id.til_password);
        passwordRegister = findViewById(R.id.editText_passwordRegister);
        passwordRegister.setText("Abcd_1234");

        buttonFacebook = findViewById(R.id.button_facebookRegister);
        buttonFacebook.setOnClickListener((evt) -> { onFacebookClick(); });

        buttonGoogle = findViewById(R.id.button_googleRegister);
        buttonGoogle.setOnClickListener((evt) -> { onGoogleClick(); });
    }

    private void onFacebookClick(){

    }

    private void onGoogleClick(){

    }


}