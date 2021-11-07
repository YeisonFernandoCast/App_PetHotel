package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {


    ImageView ivLogo;
    TextInputEditText EmailRegister;
    TextInputEditText passwordRegister;

    AppCompatButton buttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        ivLogo = findViewById(R.id.logoRegister);

        EmailRegister = findViewById(R.id.editText_emailRegister);
        EmailRegister.setText("example@gmail.com");

        passwordRegister = findViewById(R.id.editText_passwordRegister);
        passwordRegister.setText("Abcd_1234");

        buttonRegister = findViewById(R.id.button_register_launch);
        buttonRegister.setOnClickListener((evt) -> {
            EmailRegister.setText("");
            Toast.makeText(this, "Registro Completo", Toast.LENGTH_SHORT).show();
        });


    }
}