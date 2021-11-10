package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    }
    public void Tipback(View view){
        Intent Tipback = new Intent(this, TipsActivity.class);
        startActivity(Tipback);
    }
}