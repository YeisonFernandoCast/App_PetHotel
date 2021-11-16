package com.faroti.petshotel.mvp;

public interface LoginMVP {

    interface Model {

        void validateCredentials(String email, String password, ValidateCredentialsCallback callback);

        interface ValidateCredentialsCallback{
            void onSuccess();
            void onFailure(String error);
        }
    }

    interface Presenter {
        void loginWithEmail();
        void loginWithFacebook();
        void loginWithGoogle();


    }

    interface View {
        LoginInfo getLoginInfo();
        void showEmailError(String error);
        void showPasswordError(String error);
        void showGeneralError(String error);

        void clearData();

        void openSearchContactActivity();

        void startWaiting();
        void stopWaiting();
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
