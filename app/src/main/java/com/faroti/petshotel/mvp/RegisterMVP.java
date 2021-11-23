package com.faroti.petshotel.mvp;

import android.app.Activity;

public interface RegisterMVP {

    interface Model{
        void validateCredentials(String email, ValidateCredentialsCallback callback);

        interface ValidateCredentialsCallback{
            void onSuccess();
            void onFailed(String error);
        }
    }

    interface Presenter{
        void RegisterWithEmail();
        void RegisterWithFacebook();
        void RegisterWithGoogle();
    }

    interface View {
        Activity getActivity();
        RegisterInfo getRegisterInfo();
        void showEmailError(String error);
        void showPasswordError (String error);
        void showGeneralError(String error);
        void clearData();
        void SearchActivity();

        void startWaiting();
        void stopWaiting();
    }

    class RegisterInfo{
        private String email;
        private String password;

        public RegisterInfo(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }
    }
}
