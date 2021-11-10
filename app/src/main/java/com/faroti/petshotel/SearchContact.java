package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SearchContact extends AppCompatActivity {

    ImageView ivInit;
    ImageView ivOut;
    TextInputLayout tilSearch;
    TextInputEditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        initUI();
    }

    private void initUI() {
        ivInit = findViewById(R.id.iv_init);
        ivOut = findViewById(R.id.iv_out);

        tilSearch = findViewById(R.id.til_search);
        etSearch = findViewById(R.id.et_search);


        ivInit.setOnClickListener((evt) -> onInitClick());

    }

    private void onInitClick(){
        Intent intent = new Intent(this, union_base_activity.class);
        startActivity(intent);
    }

}