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
    public boolean validateCredentials(String email, String password) {




        return users.get(email) != null
                && users.get(email).equals(password);
    }
}
