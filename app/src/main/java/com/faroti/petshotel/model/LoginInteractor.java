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
    public boolean validateCredentials(String email, String password) {
        if (users.get(email) != null
                && users.get(email).equals(password)){
            return true;
        }
        return false;
    }
}
