package com.faroti.petshotel.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.faroti.petshotel.R;
import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {


    MaterialButton buttonRegisterUser;
    AppCompatButton buttonGoToLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        initIU();
    }

    private void initIU() {
        buttonRegisterUser = findViewById(R.id.button_go_to_register_user);
        buttonRegisterUser.setOnClickListener((evt) -> onRegisterUserClick());

        buttonGoToLogin = findViewById(R.id.login_register);
        buttonGoToLogin.setOnClickListener((evt) -> onLoginClick());
    }

    private void onLoginClick() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void onRegisterUserClick(){
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Registro Completo", Toast.LENGTH_SHORT).show();
    }
}