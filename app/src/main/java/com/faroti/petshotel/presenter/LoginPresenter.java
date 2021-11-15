package com.faroti.petshotel.presenter;

import com.faroti.petshotel.model.LoginInteractor;
import com.faroti.petshotel.mvp.LoginMVP;

public class LoginPresenter implements LoginMVP.Presenter{

    private LoginMVP.View view;
    private LoginMVP.Model model;

    public LoginPresenter(LoginMVP.View view){
        this.view = view;
        this.model = new LoginInteractor();
    }

    @Override
    public void loginWithEmail() {
        boolean error = false;

        view.showEmailError("");
        view.showPasswordError("");

        LoginMVP.LoginInfo loginInfo = view.getLoginInfo();
            if(loginInfo.getEmail().trim().isEmpty()){
                view.showEmailError("Correo electrónico es obligatorio");
                error = true;
            } else if (!isEmailValid(loginInfo.getEmail().trim() )){
                view.showEmailError("Correo electrónico no es válido");
                error = true;
            }


            if(loginInfo.getPassword().trim().isEmpty()){
                view.showPasswordError("Contraseña es obligatoria");
                error = true;
            } else if(!isPasswordvalid(loginInfo.getPassword().trim())){
                view.showPasswordError("Contraseña no cumple criterios de seguridad");
                error = true;
            }
            if(!error){
                // Validar que el usuario/contraseña sean correctos
                model.validateCredentials(loginInfo.getEmail().trim(),
                        loginInfo.getPassword().trim(),
                        new LoginMVP.Model.ValidateCredentialsCallback(){
                            @Override
                            public void onSuccess() {
                                view.openSearchContactActivity();
                            }

                            @Override
                            public void onFailure(String error) {
                                view.showGeneralError(error);
                            }
                });
            }
    }
    //TODO VALIDAR USER

    private boolean isEmailValid(String email) {
        return email.contains("@") && email.endsWith(".com");
    }

    private boolean isPasswordvalid(String password) {
        return password.length() > 7;
    }

    @Override
    public void loginWithFacebook() {

    }

    @Override
    public void loginWithGoogle() {

    }
}
