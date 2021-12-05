package com.faroti.petshotel.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.faroti.petshotel.R;
import com.faroti.petshotel.mvp.RegisterMVP;
import com.faroti.petshotel.presenter.RegisterPresenter;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterUserActivity extends AppCompatActivity implements RegisterMVP.View {

    private final static String EMAIL_KEY = "email";
    private final static String PASSWORD_KEY = "password";
    private final static String CELLPHONE_KEY = "cellPhone";
    private final static String USERNAME_KEY = "userName";


    private CircularProgressIndicator  progressCircularWaiting;
    private ImageView logoRegister;
    private TextInputLayout tilEmail;
    private TextInputEditText emailRegister;
    private TextInputLayout tilPassword;
    private TextInputEditText passwordRegister;
    private TextInputLayout tilCellPhoneUser;
    private TextInputEditText cellPhoneUser;
    private TextInputLayout tilUserName;
    private TextInputEditText userName;


    private AppCompatButton buttonSingUpUser;

    private RegisterMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        presenter = new RegisterPresenter(this);
        initUI();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putString(EMAIL_KEY,emailRegister.getText().toString());
        outState.putString(PASSWORD_KEY,passwordRegister.getText().toString());
        outState.putString(CELLPHONE_KEY,cellPhoneUser.getText().toString());
        outState.putString(USERNAME_KEY,userName.getText().toString());

        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        emailRegister.setText(savedInstanceState.getString(EMAIL_KEY));
        passwordRegister.setText(savedInstanceState.getString(PASSWORD_KEY));
        cellPhoneUser.setText(savedInstanceState.getString(CELLPHONE_KEY));
        userName.setText(savedInstanceState.getString(USERNAME_KEY));
    }

    private void initUI() {
        progressCircularWaiting = findViewById(R.id.progress_circular_waiting);

        logoRegister = findViewById(R.id.logo_register);

        tilEmail = findViewById(R.id.til_email_register);
        emailRegister = findViewById(R.id.edit_text_email_register);
        emailRegister.setText("example@gmail.com");

        tilPassword = findViewById(R.id.til_password_register);
        passwordRegister = findViewById(R.id.edit_text_password_register);
        passwordRegister.setText("12345678");

        tilCellPhoneUser = findViewById(R.id.til_cellphone_register);
        cellPhoneUser = findViewById(R.id.edit_text_cellphone_register);
        cellPhoneUser.setText("1234567890");

        tilUserName = findViewById(R.id.til_name_register);
        userName = findViewById(R.id.edit_text_name_register);



        buttonSingUpUser = findViewById(R.id.button_register_user);
        buttonSingUpUser.setOnClickListener((evt) -> presenter.RegisterWithEmail());
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public RegisterMVP.RegisterInfo getRegisterInfo() {
        return new RegisterMVP.RegisterInfo(emailRegister.getText().toString(),
                                            passwordRegister.getText().toString(),
                                            cellPhoneUser.getText().toString(),
                                            userName.getText().toString());
    }

    @Override
    public void showEmailError(String error) {
        tilEmail.setError(error);
    }

    @Override
    public void showPasswordError(String error) {
        tilPassword.setError(error);
    }

    @Override
    public void showCellPhoneError(String error) {
        tilCellPhoneUser.setError(error);
    }

    @Override
    public void showUserNameError(String error) {
        tilUserName.setError(error);
    }


    @Override
    public void showGeneralError(String error) {
        Toast.makeText(RegisterUserActivity.this,error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearData() {
        tilEmail.setError("");
        emailRegister.setText("");
        tilPassword.setError("");
        passwordRegister.setText("");
        tilCellPhoneUser.setError("");
        cellPhoneUser.setText("");
        tilUserName.setError("");
        userName.setText("");
    }

    @Override
    public void SearchActivity() {
        Intent intent = new Intent(this, SearchContact.class);
        startActivity(intent);
    }

    @Override
    public void startWaiting() {
        progressCircularWaiting.setVisibility(View.VISIBLE);
        buttonSingUpUser.setEnabled(false);
    }

    @Override
    public void stopWaiting() {
        progressCircularWaiting.setVisibility(View.GONE);
        buttonSingUpUser.setEnabled(true);
    }
}