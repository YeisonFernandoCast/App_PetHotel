package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    AppCompatButton buttonRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);


        buttonRegister = findViewById(R.id.button_register);
        buttonRegister.setOnClickListener((evt) -> { onRegisterClick();

        });
    };

    private void onRegisterClick(){
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Registro Completo", Toast.LENGTH_SHORT).show();
    }
}