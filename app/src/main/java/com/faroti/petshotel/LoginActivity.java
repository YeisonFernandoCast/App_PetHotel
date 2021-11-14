package com.faroti.petshotel;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {

    AppCompatButton buttonGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initIU();
    }

    private void initIU() {
        buttonGoToRegister = findViewById(R.id.register_init_login);
        buttonGoToRegister.setOnClickListener((evt) -> onRegisterInitClick());
    }

    private void onRegisterInitClick() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}