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
        logoRegister = findViewById(R.id.logo_register);

        tilEmail = findViewById(R.id.til_email_register);
        EmailRegister = findViewById(R.id.edit_text_email_register);
        EmailRegister.setText("example@gmail.com");

        tilPassword = findViewById(R.id.til_password_register);
        passwordRegister = findViewById(R.id.edit_text_password_register);
        passwordRegister.setText("Abcd_1234");

        buttonFacebook = findViewById(R.id.button_facebook_register);
        buttonFacebook.setOnClickListener((evt) -> { onFacebookClick(); });

        buttonGoogle = findViewById(R.id.button_google_register);
        buttonGoogle.setOnClickListener((evt) -> { onGoogleClick(); });
    }

    private void onFacebookClick(){

    }

    private void onGoogleClick(){

    }

}