package com.faroti.petshotel.mvp;

public interface RegisterMVP {

    interface Model{

    }

    interface Presenter{
        void RegisterWithEmail();
        void RegisterWithFacebook();
        void RegisterWithGoogle();
    }

    interface View {
        RegisterInfo getRegisterInfo();
        void showEmailError(String error);
        void showPasswordError (String error);
        void showGeneralMessage(String error);
        void clearData();
        void openNewActivity();

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
