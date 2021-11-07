package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LaunchRegister extends AppCompatActivity {


    AppCompatButton buttonRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_register);


        buttonRegister = findViewById(R.id.button_register_launch);
        buttonRegister.setOnClickListener((evt) -> {
            Toast.makeText(this, "Registro Completo", Toast.LENGTH_SHORT).show();
        });


    }
}