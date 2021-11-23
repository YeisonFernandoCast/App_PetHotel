package com.faroti.petshotel.presenter;

import com.faroti.petshotel.model.RegisterInteractor;
import com.faroti.petshotel.mvp.RegisterMVP;

public class RegisterPresenter implements RegisterMVP.Presenter {

    private RegisterMVP.View view;
    private RegisterMVP.Model model;

    public RegisterPresenter (RegisterMVP.View view){
        this.view = view;
        this.model = new RegisterInteractor();
    }


    @Override

    //condiciones de registro

    public void RegisterWithEmail() {
        boolean error = false;
        view.showEmailError("");
        view.showPasswordError("");

        RegisterMVP.RegisterInfo registerInfo = view.getRegisterInfo();
        if(registerInfo.getEmail().trim().isEmpty()){
            view.showEmailError("Correo Electrónico es obligatorio");
            error = true;
        } else if (!isEmailValid(registerInfo.getEmail().trim())) {
            view.showEmailError("Correo Electrónico invalido");
            error = true;
        }

        if(!error) {
            view.startWaiting();
            new Thread(()-> model.validateCredentials(
                    registerInfo.getEmail().trim(),
                    new RegisterMVP.Model.ValidateCredentialsCallback() {
                        @Override
                        public void onSuccess() {
                            view.getActivity().runOnUiThread(()->{
                                view.stopWaiting();
                                view.SearchActivity();
                            });
                        }
                        @Override
                        public void onFailed(String error) {
                            view.getActivity().runOnUiThread(()->{
                                view.stopWaiting();
                                view.showEmailError(error);
                            });
                        }
                    })).start();
        }

        if(registerInfo.getPassword().trim().isEmpty()){
            view.showPasswordError("Contraseña es obligatoria");
            error = true;
        } else if (!isPasswordValid(registerInfo.getPassword().trim())) {
            view.showPasswordError("Contraseña no cumple cricterio de seguridad");
            error = true;
        }

        /*
        //validar credenciales
        if(!error) {
            view.startWaiting();
            new Thread(()->{
                model.validateCredentials(
                        registerInfo.getEmail().trim(),
                        new RegisterMVP.Model.ValidateCredentialsCallback() {
                            @Override
                            public void onSuccess() {
                                view.getActivity().runOnUiThread(()->{
                                    view.stopWaiting();
                                    view.SearchActivity();
                                });
                            }
                            @Override
                            public void onFailed(String error) {
                                view.getActivity().runOnUiThread(()->{
                                    view.stopWaiting();
                                    view.showEmailError(error);
                                });
                            }
                        });
            }).start();
        }
         */
    }

    private boolean isEmailValid(String email) {
         return email.contains("@") && email.endsWith(".com");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    @Override
    public void RegisterWithFacebook() {

    }

    @Override
    public void RegisterWithGoogle() {

    }
}
