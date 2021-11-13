package com.faroti.petshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class InfoContact extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private MaterialToolbar appBar;
    private NavigationView navigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contact);

        initUI();
    }

    private void initUI() {
        drawerLayout = findViewById(R.id.drawer_layout);

        appBar = findViewById(R.id.app_bar);
        appBar.setNavigationOnClickListener(v ->openDrawer());

        navigationDrawer = findViewById(R.id.navigation_drawer);
        navigationDrawer.setNavigationItemSelectedListener(this::navigationitenSelected);


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

}