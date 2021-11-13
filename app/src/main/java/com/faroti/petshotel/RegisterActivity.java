package com.faroti.petshotel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class RegisterActivity extends AppCompatActivity {


    AppCompatButton buttonRegisterUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        buttonRegisterUser = findViewById(R.id.button_go_to_register_user);
        buttonRegisterUser.setOnClickListener((evt) -> onRegisterUserClick());
    }

    private void onRegisterUserClick(){
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Registro Completo", Toast.LENGTH_SHORT).show();
    }
}