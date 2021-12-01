package com.faroti.petshotel.mvp;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

public interface SearchContactMVP {
    interface Model{
        void loadSearchContact(LoadSearchContactCallback callback);

        interface LoadSearchContactCallback{
            void showSearchContactInfo(List<SearchContactInfo> searchContactInfo);
        }
    }

    interface Presenter{
        void onBackPressed();
        void logout();
        void loadSearchContact();
        void onInfoContactClick();

        void onItemSelected(SearchContactInfo info);
    }

    interface View{
        Activity getActivity();

        void getUnionBaseActivity();

        void showProgressBar();

        void hideProgressBar();

        void showSearchContactInfo(List<SearchContactInfo> searchContactInfo);

        void openLocationActivity(Bundle params);
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
