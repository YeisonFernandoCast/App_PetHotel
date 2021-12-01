package com.faroti.petshotel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;


import com.faroti.petshotel.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);

        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");

        LatLng location = new LatLng(4, -72);
        try {
            Geocoder geo = new Geocoder(LocationActivity.this.getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geo.getFromLocationName(address, 1);
            if (!addresses.isEmpty()) {
                location = new LatLng(addresses.get(0).getLatitude(),
                        addresses.get(0).getLongitude());
            }
        } catch (Exception e) {
            e.printStackTrace(); // getFromLocation() may sometimes fail
        }


        // Add a marker in Sydney and move the camera

        mMap.addMarker(new MarkerOptions()
                .position(location)
                .title(name+" - "+address));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 14f));
    }
}