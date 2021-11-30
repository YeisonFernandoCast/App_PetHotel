package com.faroti.petshotel.model;

import android.content.Context;

import com.faroti.petshotel.model.database.entities.User;
import com.faroti.petshotel.model.repository.FirebaseAuthRepository;
import com.faroti.petshotel.model.repository.UserRepository;
import com.faroti.petshotel.mvp.RegisterMVP;

public class RegisterInteractor implements RegisterMVP.Model {

    private UserRepository userRepository;
    private FirebaseAuthRepository AUTH;


    public RegisterInteractor(Context context){
        AUTH = new FirebaseAuthRepository(context);
        userRepository = UserRepository.getInstance(context);
    }


    @Override
    public void validateCredentials(String email, ValidateCredentialsCallback callback) {
        userRepository.getUserByEmail(email, new UserRepository.UserCallBack<User>() {
           @Override
           public void onSuccess(User user) {
               if(user != null) {
                   callback.onFailed("Correo ya existe");
               }else{
                   callback.onSuccess();
               }
           }

           @Override
           public void onFail() {
               callback.onFailed("Error al conectar a la base de datos");
           }
       });
    }

    public void insertNewUser(User user){
        AUTH.newUser(user, new FirebaseAuthRepository.FirebaseAuthCallback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onFail() {
            }
        });
    }
 /*
    public void insertNewUser(String name, String email, String password, String cellPhone){
       userRepository.newUser(name, email, password, cellPhone);
     }

  */

}
