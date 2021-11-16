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
    public void RegisterWithEmail() {
        RegisterMVP.RegisterInfo registerInfo = view.getRegisterInfo();

        if(registerInfo.getEmail().trim().isEmpty()){
            view.showEmailError("Correo Electrónico es obligatorio");
        }
        if(registerInfo.getPassword().trim().isEmpty()){
            view.showPasswordError("Contraseña es obligatoria");
        }

    }

        @Override
    public void RegisterWithFacebook() {

    }

    @Override
    public void RegisterWithGoogle() {

    }
}
