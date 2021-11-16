package com.faroti.petshotel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.faroti.petshotel.R;
import com.faroti.petshotel.mvp.SearchContactMVP;
import com.faroti.petshotel.presenter.SearchContactPresenter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
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

    //private RecyclearView rvSearchContact;
    private SearchContactMVP.Presenter presenter;

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
        appBar.setNavigationOnClickListener(v ->openDrawer());

        navigationDrawer = findViewById(R.id.navigation_drawer);
        navigationDrawer.setNavigationItemSelectedListener(this::navigationitenSelected);

        ivInitContact = findViewById(R.id.iv_init);
        ivOutContact = findViewById(R.id.iv_out);

        tilSearch = findViewById(R.id.til_search);
        etSearch = findViewById(R.id.et_search);


        ivInitContact.setOnClickListener((evt) -> onInitClick());

    }

    private void onInitClick(){
        Intent intent = new Intent(this, InfoContact.class);
        startActivity(intent);
    }

    private void openDrawer(){
        drawerLayout.openDrawer(navigationDrawer);
    }

    private boolean navigationitenSelected(MenuItem menuItem){
        menuItem.setChecked(true);
        Toast.makeText(this, menuItem.getTitle(),Toast.LENGTH_SHORT).show();
        drawerLayout.closeDrawer(navigationDrawer);
        return true;
    }

    @Override
    public Activity getActivity() {
        return SearchContact.this;
    }

    @Override
    public void showSearchContactInfo(List<SearchContactMVP.SearchContactInfo> searchContactInfo) {
        //TODO Cargar la información en el RecyclerView
    }
}