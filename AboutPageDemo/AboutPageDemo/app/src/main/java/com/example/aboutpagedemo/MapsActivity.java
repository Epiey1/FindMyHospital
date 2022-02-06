package com.example.aboutpagedemo;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.aboutpagedemo.databinding.ActivityMaps2Binding;

import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;

    MarkerOptions marker;
    LatLng centerlocation;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(3.0, 101);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Hospital Kangar")
                .position(new LatLng(6.4409, 100.1914))
                .snippet("Open 24 hours ")

        );

        markerOptions.add(new MarkerOptions().title("Hospital Sultanah Bahiyah")
                .position(new LatLng(6.12, 100.37))
                .snippet("Open 24 hours ")

        );


        markerOptions.add(new MarkerOptions().title("Hospital Sungai Petani")
                .position(new LatLng(5.64, 100.50))
                .snippet("Open 24 hours ")

        );

        markerOptions.add(new MarkerOptions().title("Hospital Raja Permaisuri Bainun")
                .position(new LatLng(4.6039, 101.0902))
                .snippet("Open 24 hours ")

        );

        markerOptions.add(new MarkerOptions().title("Hospital Kuala Krai")
                .position(new LatLng(5.5359, 102.1991))
                .snippet("Open 24 hours ")

        );

        markerOptions.add(new MarkerOptions().title("Hospital Machang")
                .position(new LatLng(5.7632, 102.22581))
                .snippet("Open 24 hours ")

        );

        markerOptions.add(new MarkerOptions().title("Hospital Langkawi")
                .position(new LatLng(6.32, 99.79))
                .snippet("Open 24 hours ")

        );

        markerOptions.add(new MarkerOptions().title("Hospital Pulau Pinang")
                .position(new LatLng(5.4171, 100.3114))
                .snippet("Open 24 hours ")

        );

        markerOptions.add(new MarkerOptions().title("Hospital Teluk Intan")
                .position(new LatLng(4.0046, 101.0403))
                .snippet("Open 24 hours ")

        );
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
// Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for (MarkerOptions mark : markerOptions) {
            mMap.addMarker(mark);

        }

        enableMyLocation();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation, 6));
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled (true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions (this,perms, 200);
        }
    }

}



