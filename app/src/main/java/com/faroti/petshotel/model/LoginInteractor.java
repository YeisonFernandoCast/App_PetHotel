package com.faroti.petshotel.model;

import android.content.Context;
import android.util.Log;

import com.faroti.petshotel.model.database.entities.User;
import com.faroti.petshotel.model.repository.UserRepository;
import com.faroti.petshotel.mvp.LoginMVP;

import java.util.List;

public class LoginInteractor implements LoginMVP.Model {

    private UserRepository userRepository;


    public LoginInteractor (Context context){
        userRepository = UserRepository.getInstance(context);
    }


    @Override
    public void validateCredentials(String email, String password, ValidateCredentialsCallback callback) {
        userRepository.getUserByEmail(email, new UserRepository.UserCallBack<User>() {
            @Override
            public void onSuccess(User user) {
                if (user == null){
                    callback.onFailure("Usuario no existe");
                } else if (!user.getPassword().equals(password)){
                    callback.onFailure("Contraseña incorrecta");
                } else {
                    callback.onSuccess();
                }
            }

            @Override
            public void onFail() {
                callback.onFailure("Error al conectar a la base de datos");

            }
        });

        userRepository.getAll(new UserRepository.UserCallBack<List<User>>() {
            @Override
            public void onSuccess(List<User> data) {
                for (User user : data){
                    Log.w(LoginInteractor.class.getSimpleName(), user.toString());
                }
            }

            @Override
            public void onFail() {
                Log.w(LoginInteractor.class.getSimpleName(),"Problemas al obtener los datos");
            }
        });

    }
}
