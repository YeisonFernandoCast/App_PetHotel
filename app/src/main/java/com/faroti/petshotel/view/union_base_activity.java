package com.faroti.petshotel.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.bumptech.glide.Glide;
import com.faroti.petshotel.R;

public class union_base_activity extends AppCompatActivity {
    AppCompatButton buttonRegister;
    AppCompatButton buttonTips;
    AppCompatButton buttonContact;
    AppCompatButton buttonLogin;
    ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_PetsHotel);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_union_base);

        background = findViewById(R.id.background);

        Glide.with(this)
                .load(R.mipmap.perro_gato)
                .centerCrop()
                .circleCrop()
                .into(background);
        //hideSystemUI();
        initIU();

    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                         View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                 | View.SYSTEM_UI_FLAG_FULLSCREEN
                                 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                 | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                 | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                 | View.SYSTEM_UI_FLAG_IMMERSIVE);
        // Set the content to appear under the system bars so that the
        // content doesn't resize when the system bars hide and show.


        // Hide the nav bar and status bar
    }

    private void initIU() {

        //buttonTips = findViewById(R.id.union_tips);
        //buttonTips.setOnClickListener((evt)-> onUnionTipsClick());

        //buttonContact = findViewById(R.id.union_contact);
        //buttonContact.setOnClickListener((evt)-> onUnionContactClick());

        buttonRegister = findViewById(R.id.union_register);
        buttonRegister.setOnClickListener((evt)-> onUnionRegisterClick());

        buttonLogin = findViewById(R.id.union_login);
        buttonLogin.setOnClickListener((evt)-> onUnionLoginClick());
    }

    private void onUnionLoginClick() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
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
