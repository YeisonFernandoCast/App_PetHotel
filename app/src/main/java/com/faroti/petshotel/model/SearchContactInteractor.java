package com.faroti.petshotel.model;

import com.faroti.petshotel.mvp.SearchContactMVP;

import java.util.ArrayList;

public class SearchContactInteractor implements SearchContactMVP.Model {

    @Override
    public void loadSearchContact(LoadSearchContactCallback callback) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.showSearchContactInfo(new ArrayList<>());
    }
}
