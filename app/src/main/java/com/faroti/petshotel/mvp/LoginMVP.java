package com.faroti.petshotel.mvp;

import android.app.Activity;
import android.content.Intent;


public interface LoginMVP {

    interface Model {

        void validateCredentials(String email, String password, ValidateCredentialsCallback callback);

        boolean isAuthenticated();

        Intent getGoogleSignIntent();

        void setGoogleData(Intent data, ValidateCredentialsCallback callback);

        interface ValidateCredentialsCallback{
            void onSuccess();
            void onFailure(String error);
        }
    }

    interface Presenter {
        void isAuthenticated();
        void isLogged();
        void loginWithEmail();
        void loginWithFacebook();
        void loginWithGoogle();

        void setGoogleData(Intent data);
    }

    interface View {
        Activity getActivity();

        LoginInfo getLoginInfo();
        void showEmailError(String error);
        void showPasswordError(String error);
        void showGeneralError(String error);
        void showToastError(String error);

        void clearData();

        void openSearchContactActivity();

        void startWaiting();
        void stopWaiting();

        void openGoogleSignInActivity(Intent intent);
    }

    class LoginInfo{
        private String email;
        private String password;

        public LoginInfo(String email, String password) {
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
