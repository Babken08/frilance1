package com.example.armen.monitoring;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private Marker testMarker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        final LatLng moscow = new LatLng(55.751244, 37.618423);
        addMarker(mMap, moscow);

        final LatLng moscow1 = new LatLng(55.751299, 37.615252);
        final LatLng moscow2 = new LatLng(55.752482, 37.618555);
        final LatLng moscow3 = new LatLng(55.01, 36.01);
        final LatLng moscow4 = new LatLng(55.01, 37.00);
        LatLng moscow5 = new LatLng(55.01, 38.00);

        addMarker(mMap, moscow1);
        addMarker(mMap, moscow2);
        addMarker(mMap, moscow3);
        addMarker(mMap, moscow4);
        addMarker(mMap, moscow5);
        LatLngBounds.Builder bounds = new LatLngBounds.Builder();
                bounds.include(moscow);
                bounds.include(moscow1);
                bounds.include(moscow2);
//                bounds.include(moscow3);
//                bounds.include(moscow4);
//                bounds.include(moscow5);
        final LatLngBounds boundss = bounds.build();

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(boundss, 50));
            }
        });

        mMap.setOnInfoWindowClickListener(this);
//        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(boundss, 50));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(moscow, 13));
//        mMap.setOnMarkerClickListener(this);

    }

        @OnClick(R.id.btn_shops)
        void clickBtnShop () {
            startActivity(new Intent(MapsActivity.this, ShopsActivity.class));
        }

//    @Override
//    public boolean onMarkerClick(Marker marker) {
//
//        if(marker.equals(markerMoscow)) {
//            startActivity(new Intent(MapsActivity.this, TasksActivity.class));
//        }
//        if(marker.equals(markerMoscow1)) {
//            startActivity(new Intent(MapsActivity.this, TasksActivity.class));
//        }
//        if(marker.equals(markerMscow2)) {
//            startActivity(new Intent(MapsActivity.this, TasksActivity.class));
//        }
//        if(marker.equals(markerMoscow3)) {
//            startActivity(new Intent(MapsActivity.this, TasksActivity.class));
//        }
//        if(marker.equals(markerMoscow4)) {
//            startActivity(new Intent(MapsActivity.this, TasksActivity.class));
//        }
//        if(marker.equals(markerMoscow5)) {
//            startActivity(new Intent(MapsActivity.this, TasksActivity.class));
//        }
//        return false;
//    }

        private void addMarker (GoogleMap map, LatLng latLng){
           map.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                    .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                    .position(latLng)
                    .title("Hello world")
                     .snippet("Population: 4,137,400"));

        }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "click title in marker", Toast.LENGTH_SHORT).show();
    }
}
