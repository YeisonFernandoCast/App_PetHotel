package com.faroti.petshotel.model;

import com.faroti.petshotel.mvp.LoginMVP;

import java.util.HashMap;
import java.util.Map;

public class LoginInteractor implements LoginMVP.Model {

    private Map<String, String> users;
    public LoginInteractor (){
        users = new HashMap<>();
        users.put("jfpacheco11@gmail.com","12345678");
        users.put("hre-palacios@hotmail.com","12345678");
        users.put("yeisonfcu@outlook.com","12345678");
        users.put("johan@gmail.com","12345678");
    }


    @Override
    public void validateCredentials(String email, String password, ValidateCredentialsCallback callback) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (users.get(email) == null){
            callback.onFailure("Usuario no existe");
        } else if (!users.get(email).equals(password)){
            callback.onFailure("Contraseña incorrecta");
        } else {
            callback.onSuccess();
        }

    }
}
