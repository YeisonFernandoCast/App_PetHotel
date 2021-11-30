package com.faroti.petshotel.mvp;

import android.app.Activity;

import com.faroti.petshotel.model.database.entities.User;

public interface RegisterMVP {

    interface Model{

        boolean isAuthenticated();

        void validateCredentials(String email, ValidateCredentialsCallback callback);
        interface ValidateCredentialsCallback{
            void onSuccess();
            void onFailed(String error);
        }

        void insertNewUser(User user);
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
        void showCellPhoneError(String error);
        void showUserNameError (String error);
        void showGeneralError(String error);
        void clearData();
        void SearchActivity();

        void startWaiting();
        void stopWaiting();
    }

    class RegisterInfo{
        private String email;
        private String password;
        private String cellPhone;
        private String userName;

        public RegisterInfo(String email, String password, String cellPhone, String userName) {
            this.email = email;
            this.password = password;
            this.cellPhone = cellPhone;
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }
        public String getCellPhone() {
            return cellPhone;
        }
        public String getUserName() { return userName;
        }
    }
}
