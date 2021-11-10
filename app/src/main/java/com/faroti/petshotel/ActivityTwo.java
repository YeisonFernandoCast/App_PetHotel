package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityTwo extends AppCompatActivity {

    AppCompatButton buttonTipBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_two);
        buttonTipBack = findViewById(R.id.button_tips);
        buttonTipBack.setOnClickListener((evt) -> onButtonClick());
    }



    private void onButtonClick() {
        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);
    }
}