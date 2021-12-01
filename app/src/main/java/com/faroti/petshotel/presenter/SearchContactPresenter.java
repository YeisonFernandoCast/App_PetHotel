package com.faroti.petshotel.presenter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.faroti.petshotel.R;
import com.faroti.petshotel.model.SearchContactInteractor;
import com.faroti.petshotel.model.repository.FirebaseAuthRepository;
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

    @Override
    public void onItemSelected(SearchContactMVP.SearchContactInfo info) {
        Bundle params = new Bundle();
        params.putString("name", info.getName());
        params.putString("address", info.getAddress());

        view.openLocationActivity(params);
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getActivity());
        builder.setTitle(R.string.app_name)
                .setMessage("Desea cerrar sesión?")
                .setPositiveButton("Si", (dialog, which) -> {
                    FirebaseAuthRepository.getInstance(view.getActivity())
                            .logout(new FirebaseAuthRepository.FirebaseAuthCallback() {
                        @Override
                        public void onSuccess() {
                           view.getActivity().onBackPressed();
                           view.getUnionBaseActivity();
                        }
                        @Override
                        public void onFail() {
                            Toast.makeText(view.getActivity(), "Error al cerrar la sesion",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

                })
                .setNegativeButton("No", null);
        builder.create().show();

    }


    public void logout() {
        SharedPreferences preferences= view.getActivity()
                .getSharedPreferences("authentication", Context.MODE_PRIVATE);
        preferences.edit()
                .putBoolean("logged",false)
                .apply();
    }

}
