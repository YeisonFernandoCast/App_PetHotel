package com.faroti.petshotel.presenter;

import com.faroti.petshotel.model.SearchContactInteractor;
import com.faroti.petshotel.mvp.SearchContactMVP;

import java.util.List;

public class SearchContactPresenter implements SearchContactMVP.Presenter {
    private SearchContactMVP.View view;
    private SearchContactMVP.Model model;

    public SearchContactPresenter(SearchContactMVP.View view) {
        this.view = view;
        this.model = new SearchContactInteractor();
    }

    @Override
    public void loadSearchContact() {
        view.showProgressBar();
        new Thread(()->{
            model.loadSearchContact(new SearchContactMVP.Model.LoadSearchContactCallback() {
                @Override
                public void showSearchContactInfo(List<SearchContactMVP.SearchContactInfo> searchContactInfo) {
                    view.getActivity().runOnUiThread(()->{
                        view.showSearchContactInfo(searchContactInfo);
                        view.hideProgressBar();
                    });

                }
            });
        }).start();
    }

    @Override
    public void onInfoContactClick() {

    }
}
