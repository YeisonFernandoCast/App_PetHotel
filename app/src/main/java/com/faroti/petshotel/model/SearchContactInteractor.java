package com.faroti.petshotel.model;

import com.faroti.petshotel.mvp.SearchContactMVP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchContactInteractor implements SearchContactMVP.Model {

    private List<SearchContactMVP.SearchContactInfo> data;

    public SearchContactInteractor(){
        data = Arrays.asList(
                new SearchContactMVP.SearchContactInfo("Jose Pacheco", "Cra 23 # 45-67"),
                new SearchContactMVP.SearchContactInfo("Johan Moscoso", "Cra 23 # 45-67"),
                new SearchContactMVP.SearchContactInfo("Yeison Castaño", "Cra 23 # 45-67"),
                new SearchContactMVP.SearchContactInfo("Rodrigo Estupiñán", "Cra 23 # 45-67"),
                new SearchContactMVP.SearchContactInfo("Francisco J", "Cra 23 # 45-67")
        );
    }

    @Override
    public void loadSearchContact(LoadSearchContactCallback callback) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.showSearchContactInfo(this.data);
    }
}
