package com.faroti.petshotel.model;

import android.content.Context;

import com.faroti.petshotel.model.database.entities.User;
import com.faroti.petshotel.model.repository.UserRepository;
import com.faroti.petshotel.mvp.RegisterMVP;

public class RegisterInteractor implements RegisterMVP.Model {

    private UserRepository userRepository;


    public RegisterInteractor(Context context){
        userRepository = new UserRepository(context);
    }




    @Override
    public void validateCredentials(String email, ValidateCredentialsCallback callback) {
        User user = userRepository.getUserByEmail(email);

        if(user != null) {
            callback.onFailed("Correo ya existe");
        }else{
            callback.onSuccess();
        }
    }

    public void insertNewUser(String name, String email, String password, String cellPhone){
       userRepository.newUser(name, email, password, cellPhone);
    }




}
