package com.faroti.petshotel.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.faroti.petshotel.R;

public class ActivityOne extends AppCompatActivity {

    AppCompatButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        fab = findViewById(R.id.fab_back);
        fab.setOnClickListener((evt) -> onClickBack());
    }

    public void onClickBack(){
        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);
    }
}
