package com.faroti.petshotel;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatButton;
//import com.bumptech.glide.Glide;


public class union_base_activity extends Activity {
    AppCompatButton buttonRegister;
    AppCompatButton buttonTips;
    AppCompatButton buttonContact;
    ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_union_base);

        /*
        ImageView background = findViewById(R.id.background);

        Glide.with(this) // TODO -- revisar esto
                .load(getImage("backgroud"))
                .centercorp()
                .into(background);
                */
        initIU();


    }

    public int getImage(String imageName) {
        int mipmapResourceId = this.getResources().getIdentifier(imageName, "mipmap",
                this.getPackageName());

        return mipmapResourceId;
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
