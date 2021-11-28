package com.faroti.petshotel.model;

import android.content.Context;

import com.faroti.petshotel.model.database.entities.User;
import com.faroti.petshotel.model.repository.UserRepository;
import com.faroti.petshotel.mvp.LoginMVP;

public class LoginInteractor implements LoginMVP.Model {

    private UserRepository userRepository;


    public LoginInteractor (Context context){
        userRepository = new UserRepository(context);
    }


    @Override
    public void validateCredentials(String email, String password, ValidateCredentialsCallback callback) {
        User user = userRepository.getUserByEmail(email);

        if (user == null){
            callback.onFailure("Usuario no existe");
        } else if (!user.getPassword().equals(password)){
            callback.onFailure("Contraseña incorrecta");
        } else {
            callback.onSuccess();
        }

    }
}
