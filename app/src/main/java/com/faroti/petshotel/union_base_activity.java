package com.faroti.petshotel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.bumptech.glide.Glide;


public class union_base_activity extends AppCompatActivity {
    AppCompatButton buttonRegister;
    AppCompatButton buttonTips;
    AppCompatButton buttonContact;
    ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN); //TODO -- no sirve con appcompatactivity
                                                                 // se utilizan con extend Activity
        }*/
/*
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); */ //TODO -- este tampoco

        setContentView(R.layout.activity_union_base);

        background.findViewById(R.id.background);

        Glide.with(this) // TODO -- revisar esto
                .load(R.mipmap.background)
                .centerCrop()
                .into(background);

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
