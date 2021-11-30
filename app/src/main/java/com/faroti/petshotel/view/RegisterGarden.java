package com.faroti.petshotel.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.faroti.petshotel.R;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterGarden extends AppCompatActivity {

    private TextInputLayout tilGardenName;
    private TextInputEditText editTextGardenName;
    private TextInputLayout tilUserNameGarden;
    private TextInputEditText editTextUserNameGarden;
    private TextInputLayout tilCellPhoneGarden;
    private TextInputEditText editTextCellPhoneGarden;
    private TextInputLayout tilGardenEmail;
    private TextInputEditText editTextGardenEmail;
    private TextInputLayout tilGardenPassword;
    private TextInputEditText editTextGardenPassword;
    private TextInputLayout tilGardenAddress;
    private TextInputEditText editTextGardenAddress;
    private TextInputLayout tilGardenCity;
    private MaterialAutoCompleteTextView editTextGardenCity;
    private AppCompatButton buttonRegisterGarden;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_garden);


        initUI();
    }

    private void initUI(){

    }
}