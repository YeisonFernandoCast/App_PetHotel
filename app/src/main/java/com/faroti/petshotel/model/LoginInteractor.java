package com.faroti.petshotel.model;

import android.content.Context;

import com.faroti.petshotel.model.repository.FirebaseAuthRepository;
import com.faroti.petshotel.model.repository.UserRepository;
import com.faroti.petshotel.mvp.LoginMVP;

public class LoginInteractor implements LoginMVP.Model {

    private UserRepository userRepository;
    private FirebaseAuthRepository AUTH;


    public LoginInteractor(Context context) {
        AUTH = FirebaseAuthRepository.getInstance(context);
        userRepository = UserRepository.getInstance(context);
    }


    @Override
    public void validateCredentials(String email, String password, ValidateCredentialsCallback callback) {
        AUTH.login(email, password,
                new FirebaseAuthRepository.FirebaseAuthCallback() {
                    @Override
                    public void onSuccess() {
                        callback.onSuccess();
                    }

                    @Override
                    public void onFail() {
                        callback.onFailure("Credenciales invalidas");
                    }
                });

        /*
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

         */

    }

    @Override
    public boolean isAuthenticated() {
        return AUTH.isAuthenticated();
    }
}
