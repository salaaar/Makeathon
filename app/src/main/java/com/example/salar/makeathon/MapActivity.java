package com.example.salar.makeathon;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        LocationListener {
    private GoogleMap mMap;
    private Button doneButton;
    int counter = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        final PolylineOptions options = new PolylineOptions();
        options.color(Color.RED);

        final ImageView markerImage = (ImageView) findViewById(R.id.activity_map_marker_image);
        markerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Marker marker = mMap.addMarker(new MarkerOptions().position(mMap.getCameraPosition().target).title("step "+counter));
                options.add(marker.getPosition());
                counter++;
                doneButton.setVisibility(View.VISIBLE);
            }
        });


        doneButton = (Button)findViewById(R.id.activity_map_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markerImage.setVisibility(View.GONE);
                options.add(options.getPoints().get(0));
                mMap.addPolyline(options);
            }
        });
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        // Add a marker in Sydney and move the camera

//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    @Override
    public void onLocationChanged(Location location) {

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}




