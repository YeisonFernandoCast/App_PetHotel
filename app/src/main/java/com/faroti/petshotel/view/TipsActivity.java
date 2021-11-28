package com.faroti.petshotel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import com.faroti.petshotel.R;


public class TipsActivity extends AppCompatActivity {

    AppCompatButton buttonTipOne;
    AppCompatButton buttonTipTwo;
    AppCompatButton buttonTipThree;
    AppCompatButton buttonTipFour;
    AppCompatButton buttonTipFive;
    AppCompatButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        initIU();
    }


    private void initIU() {

        buttonTipOne = findViewById(R.id.button1_tip);
        buttonTipOne.setOnClickListener((evt)-> onClickTipOne());

        buttonTipTwo = findViewById(R.id.button2_tip);
        buttonTipTwo.setOnClickListener((evt)-> onClickTipTwo());

        buttonTipThree = findViewById(R.id.button3_tip);
        buttonTipThree.setOnClickListener((evt)-> onClickTipThree());

        buttonTipFour = findViewById(R.id.button4_tip);
        buttonTipFour.setOnClickListener((evt)-> onClickTipFour());

        buttonTipFive = findViewById(R.id.button5_tip);
        buttonTipFive.setOnClickListener((evt)-> onClickTipFive());

        fab = findViewById(R.id.fab_back);
        fab.setOnClickListener((evt) -> onClickBack());


    }

    private void onClickTipOne() {
        Intent intent = new Intent(this, ActivityOne.class);
        startActivity(intent);
    }

    private void onClickTipTwo() {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }

    private void onClickTipThree() {
        Intent intent = new Intent(this, ActivityThree.class);
        startActivity(intent);
    }

    private void onClickTipFour() {
        Intent intent = new Intent(this, ActivityFour.class);
        startActivity(intent);
    }

    private void onClickTipFive() {
        Intent intent = new Intent(this, ActivityFive.class);
        startActivity(intent);
    }

    public void onClickBack(){
        Intent intent = new Intent(TipsActivity.this,SearchContact.class);
        startActivity(intent);
    }

}