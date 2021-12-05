package com.faroti.petshotel.model;

import com.faroti.petshotel.mvp.SearchContactMVP;

import java.util.Arrays;
import java.util.List;

public class SearchContactInteractor implements SearchContactMVP.Model {

    private List<SearchContactMVP.SearchContactInfo> data;

    public SearchContactInteractor() {
        data = Arrays.asList(
                new SearchContactMVP.SearchContactInfo("Jose Pacheco", "Cra 23AA # 8 - 79, Peñol, Colombia"),
                new SearchContactMVP.SearchContactInfo("Johan Moscoso", "calle 17 # 7 - 18,Montenegro, quindío"),
                new SearchContactMVP.SearchContactInfo("Yeison Castaño", "Cra 4B # 31A - 37 , Ibague, Colombia"),
                new SearchContactMVP.SearchContactInfo("Rodrigo Estupiñán", "Cra 23 # 45-67, Buga laGrande, Colombia"),
                new SearchContactMVP.SearchContactInfo("Francisco J", "Cra 23 # 45-67, Buga, Colombia")
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

