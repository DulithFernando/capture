package com.clayofficial.capture;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class profile extends AppCompatActivity implements View.OnClickListener {
    private TextView name, email, id, loc;
    private ImageView camera, logout;
    private Button getLocation, checkmem;
    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Casting
        id = (TextView) findViewById(R.id.userid);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        loc = (TextView) findViewById(R.id.location);
        camera = (ImageView) findViewById(R.id.camera);
        logout = (ImageView) findViewById(R.id.logout);
        checkmem = (Button) findViewById(R.id.check);
        getLocation = (Button) findViewById(R.id.get_loc);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //Listener
        camera.setOnClickListener(this);
        logout.setOnClickListener(this);
        checkmem.setOnClickListener(this);
        locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                loc.setText("Longitutde : "+location.getLatitude()+"\nLatitude : "+location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
        configure_button();
    }

    @Override
    public void onClick(View v) {

        if (v == logout) {
            Shared.getInstance(this).logOut();
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        if (v == checkmem) {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivity(gallery);
        }
    }

    void configure_button() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET},10);
            }
            return;
        }
        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationManager.requestLocationUpdates("gps", 5000, 1, locationListener);
            }
        });

    }
}
