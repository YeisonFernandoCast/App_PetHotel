package com.faroti.petshotel.mvp;

import android.app.Activity;

import java.util.List;

public interface SearchContactMVP {
    interface Model{
        void loadSearchContact(LoadSearchContactCallback callback);

        interface LoadSearchContactCallback{
            void showSearchContactInfo(List<SearchContactInfo> searchContactInfo);
        }
    }

    interface Presenter{
        void loadSearchContact();
        void onInfoContactClick();
    }

    interface View{
        Activity getActivity();

        void showProgressBar();

        void hideProgressBar();

        void showSearchContactInfo(List<SearchContactInfo> searchContactInfo);
    }

    class SearchContactInfo{
        private String image;
        private String name;
        private String address;


        public SearchContactInfo(String name, String address) {
            this(null, name, address);
        }

        public SearchContactInfo(String image, String name, String address) {
            this.image = image;
            this.name = name;
            this.address = address;
        }

        public String getImage() {
            return image;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }
}
