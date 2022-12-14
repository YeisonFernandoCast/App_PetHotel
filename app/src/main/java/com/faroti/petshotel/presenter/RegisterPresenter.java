package com.faroti.petshotel.presenter;

import com.faroti.petshotel.model.RegisterInteractor;
import com.faroti.petshotel.model.database.entities.User;
import com.faroti.petshotel.mvp.RegisterMVP;

public class RegisterPresenter implements RegisterMVP.Presenter {

    private RegisterMVP.View view;
    private RegisterMVP.Model model;

    public RegisterPresenter(RegisterMVP.View view) {
        this.view = view;
        //this.model = new RegisterInteractor();
        this.model = new RegisterInteractor(view.getActivity());
    }


    @Override

    //condiciones de registro

    public void RegisterWithEmail() {
        boolean error = false;
        view.showEmailError("");
        view.showPasswordError("");
        view.showCellPhoneError("");
        view.showUserNameError("");

        RegisterMVP.RegisterInfo registerInfo = view.getRegisterInfo();
        if (registerInfo.getEmail().trim().isEmpty()) {
            view.showEmailError("Correo Electrónico es obligatorio");
            error = true;
        } else if (!isEmailValid(registerInfo.getEmail().trim())) {
            view.showEmailError("Correo Electrónico invalido");
            error = true;
        }

        if (registerInfo.getPassword().trim().isEmpty()) {
            view.showPasswordError("Contraseña es obligatoria");
            error = true;
        } else if (!isPasswordValid(registerInfo.getPassword().trim())) {
            view.showPasswordError("Contraseña no cumple cricterio de seguridad");
            error = true;
        }

        if (registerInfo.getCellPhone().trim().isEmpty()) {
            view.showCellPhoneError("Campo Obligatorio");
            error = true;
        } else if (!isCellPhoneValid(registerInfo.getCellPhone().trim())) {
            view.showCellPhoneError("Telefono no valido");
            error = true;
        }
        if (registerInfo.getUserName().trim().isEmpty()) {
            view.showUserNameError("Campo Obligatorio");
            error = true;
        }

        User user = new User(
                registerInfo.getUserName(),
                registerInfo.getEmail(),
                registerInfo.getPassword(),
                registerInfo.getCellPhone());

        //validar credenciales
        if (!error) {
            view.startWaiting();
            new Thread(() -> {
                model.validateCredentials(
                        registerInfo.getEmail().trim(),
                        new RegisterMVP.Model.ValidateCredentialsCallback() {
                            @Override
                            public void onSuccess() {
                                model.insertNewUser(user);
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

               /* if (model.isAuthenticated()) {
                    view.getActivity().runOnUiThread(() -> {
                        view.stopWaiting();
                        view.showEmailError("correo ya existe");
                    });
                } else {
                    User user = new User(registerInfo.getUserName(),
                            registerInfo.getEmail(),
                            registerInfo.getPassword(),
                            registerInfo.getCellPhone());
                    model.insertNewUser(user);

                    view.getActivity().runOnUiThread(() -> {
                        view.stopWaiting();
                        view.SearchActivity();
                    });
                }
               -------------------------------------------------------------

                 registerInfo.getUserName(),
                                        registerInfo.getEmail(),
                                        registerInfo.getPassword(),
                                        registerInfo.getCellPhone()
                  ---------------------------------------------------------------

                         */


    }

    private boolean isCellPhoneValid(String cellPhone) {
        return cellPhone.length() == 10;
    }

    private boolean isEmailValid(String email) {

        return email.contains("@")
                && email.endsWith(".com")
                && email.contains("gmail") || email.contains("outlook") || email.contains("hotmail");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 7;
    }

}
