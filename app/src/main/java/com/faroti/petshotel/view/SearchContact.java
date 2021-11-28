package com.faroti.petshotel.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faroti.petshotel.R;
import com.faroti.petshotel.mvp.SearchContactMVP;
import com.faroti.petshotel.presenter.SearchContactPresenter;
import com.faroti.petshotel.view.adapter.SearchContactAdapter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class SearchContact extends AppCompatActivity implements SearchContactMVP.View {

    ImageView ivInitContact;
    ImageView ivOutContact;
    TextInputLayout tilSearch;
    TextInputEditText etSearch;

    private DrawerLayout drawerLayout;
    private MaterialToolbar appBar;
    private NavigationView navigationDrawer;

    private RecyclerView rvSearchContact;
    private SearchContactMVP.Presenter presenter;

    private LinearProgressIndicator piWaiting;
    private SearchContactAdapter searchContactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        presenter = new SearchContactPresenter(this);

        initUI();

        presenter.loadSearchContact();
    }

    private void initUI() {
        drawerLayout = findViewById(R.id.drawer_layout);

        appBar = findViewById(R.id.app_bar);
        appBar.setNavigationOnClickListener(v -> openDrawer());

        navigationDrawer = findViewById(R.id.navigation_drawer);
        navigationDrawer.setNavigationItemSelectedListener(this::navigationitemSelected);

        ivInitContact = findViewById(R.id.iv_init);
        ivOutContact = findViewById(R.id.iv_out);

        tilSearch = findViewById(R.id.til_search);
        etSearch = findViewById(R.id.et_search);

        piWaiting = findViewById(R.id.pi_waiting_search);
        rvSearchContact = findViewById(R.id.rv_search_contact);
        rvSearchContact.setLayoutManager(new LinearLayoutManager(SearchContact.this));
        searchContactAdapter = new SearchContactAdapter();
        rvSearchContact.setAdapter(searchContactAdapter);

        ivInitContact.setOnClickListener((evt) -> onInitClick());

    }

    private void onInitClick() {
        Intent intent = new Intent(this, InfoContact.class);
        startActivity(intent);
    }

    private void openDrawer() {
        drawerLayout.openDrawer(navigationDrawer);
    }


    private boolean navigationitemSelected(MenuItem menuItem) {
        Intent intent;
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {
            case R.id.user:
                //Toast.makeText(this, "ESO HP .....", Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawer(navigationDrawer);
                intent = new Intent(this, InfoContact.class);
                startActivity(intent);
                return true;
            case R.id.acount:
                drawerLayout.closeDrawer(navigationDrawer);
                Toast.makeText(this, "Pronto ... xD", Toast.LENGTH_LONG).show();
                return true;
            case R.id.tips:
                drawerLayout.closeDrawer(navigationDrawer);
                intent = new Intent(this, TipsActivity.class);
                startActivity(intent);
                return true;
            case R.id.contact_us:
                drawerLayout.closeDrawer(navigationDrawer);
                Toast.makeText(this, "Contactenos", Toast.LENGTH_LONG).show();
                return true;
            case R.id.close:
                drawerLayout.closeDrawer(navigationDrawer);
                presenter.logout();
                getUnionBaseActivity();
                return true;
            default:
                return true;
        }
    }

    @Override
    public Activity getActivity() {
        return SearchContact.this;
    }

    @Override
    public void getUnionBaseActivity(){
        Intent intent = new Intent(this, union_base_activity.class);
        startActivity(intent);
    }

    @Override
    public void showProgressBar() {
        piWaiting.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        piWaiting.setVisibility(View.GONE);
    }

    @Override
    public void showSearchContactInfo(List<SearchContactMVP.SearchContactInfo> searchContactInfo) {
        searchContactAdapter.setData(searchContactInfo);

        //TODO Cargar la información en el RecyclerView - Youtube 1:20min
        Toast.makeText(SearchContact.this, "Datos cargados", Toast.LENGTH_SHORT).show();
    }
}