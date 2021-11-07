package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
    }
    public void TipOne(View view){
        Intent Tipone = new Intent(this, MainActivity.class);
        startActivity(Tipone);
    }
}