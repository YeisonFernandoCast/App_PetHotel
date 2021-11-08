package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class InfoContacto extends AppCompatActivity {

    ImageView iv_inicio;
    ImageView iv_salir;
    TextInputLayout tilbuscar;
    TextInputEditText etbuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contacto);

        initUI();
    }

    private void initUI() {
        iv_inicio = findViewById(R.id.iv_inicio);
        iv_salir = findViewById(R.id.iv_salir);

        tilbuscar = findViewById(R.id.til_buscar);
        etbuscar = findViewById(R.id.et_buscar);


        iv_inicio.setOnClickListener((evt) ->{oninicioClick();});

    }

    private void oninicioClick(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}