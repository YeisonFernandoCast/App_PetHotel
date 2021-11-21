package com.faroti.petshotel.model;

import com.faroti.petshotel.mvp.RegisterMVP;

import java.util.HashMap;
import java.util.Map;

public class RegisterInteractor implements RegisterMVP.Model {

    Map<String,String> users;

    public RegisterInteractor(){
        users = new HashMap<>();
        users.put("johan@gmail.com","12345678");
    }


    @Override
    public void validateCredentials(String email, ValidateCredentialsCallback callback) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(users.get(email) != null) {
            callback.onFailed("Correo ya existe");
        }else{
            callback.onSuccess();
        }

    }
}
