package com.faroti.petshotel.model;

import com.faroti.petshotel.mvp.SearchContactMVP;

import java.util.Arrays;
import java.util.List;

public class SearchContactInteractor implements SearchContactMVP.Model {

    private List<SearchContactMVP.SearchContactInfo> data;

    public SearchContactInteractor() {
        data = Arrays.asList(
                new SearchContactMVP.SearchContactInfo("Perros Y Gatos", "Corales Mz 15 casa 14, Pereira, Risaralda"),
                new SearchContactMVP.SearchContactInfo("Huellas", "calle 69 numero 2-67, Ibagué, Tolima"),
                new SearchContactMVP.SearchContactInfo("Guarderia Canina", "Cl. 5 Sur, Medellín, Antioquia"),
                new SearchContactMVP.SearchContactInfo("Traviezoos Guarderia", "Buga - Guacarí, Guadalajara de Buga, Valle del Cauca"),
                new SearchContactMVP.SearchContactInfo("Guarderia Tails", "San Jorge Km 10, Armenia, Quindío")
        );
    }

    @Override
    public void loadSearchContact(LoadSearchContactCallback callback) {
        callback.showSearchContactInfo(this.data);
    }

}

