package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Tiponeone(View view){
        Intent Tiponeone = new Intent(this, TipsActivity.class);
        startActivity(Tiponeone);
    }
}