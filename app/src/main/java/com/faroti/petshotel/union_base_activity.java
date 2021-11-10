package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;


public class union_base_activity extends AppCompatActivity {

    AppCompatButton buttonRegister;
    AppCompatButton buttonTips;
    AppCompatButton buttonContact;
    AppCompatButton buttonPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_union_base);
        initIU();

    }

    private void initIU() {

        buttonTips = findViewById(R.id.union_tips);
        buttonTips.setOnClickListener((evt)-> onUnionTipsClick());

        buttonContact = findViewById(R.id.union_contact);
        buttonContact.setOnClickListener((evt)-> onUnionContactClick());

        buttonRegister = findViewById(R.id.union_register);
        buttonRegister.setOnClickListener((evt)-> onUnionRegisterClick());
    }

    private void onUnionContactClick() {
        Intent intent = new Intent(this, SearchContact.class);
        startActivity(intent);
    }

    private void onUnionRegisterClick(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void onUnionTipsClick(){
        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);
    }
}
