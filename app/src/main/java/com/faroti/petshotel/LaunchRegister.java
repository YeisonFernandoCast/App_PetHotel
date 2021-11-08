package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LaunchRegister extends AppCompatActivity {


    AppCompatButton buttonRegisterLaunch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_register);


        buttonRegisterLaunch = findViewById(R.id.button_register_launch);
        buttonRegisterLaunch.setOnClickListener((evt) -> { onRegisterClick();

        });
    };

    private void onRegisterClick(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Registro Completo", Toast.LENGTH_SHORT).show();
    }
}