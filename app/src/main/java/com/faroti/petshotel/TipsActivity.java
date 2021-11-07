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

    public void TipTwo(View view){
        Intent Tiptwo = new Intent(this, ActivityTwo.class);
        startActivity(Tiptwo);
    }

    public void TipThree(View view){
        Intent Tipthree = new Intent(this, ActivityThree.class);
        startActivity(Tipthree);
    }

    public void TipFour(View view){
        Intent Tipfour = new Intent(this, ActivityFour.class);
        startActivity(Tipfour);
    }

    public void TipFive(View view){
        Intent Tipfive = new Intent(this, ActivityFive.class);
        startActivity(Tipfive);
    }
}