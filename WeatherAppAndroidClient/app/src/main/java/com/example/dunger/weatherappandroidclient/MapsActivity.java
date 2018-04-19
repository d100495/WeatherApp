package com.example.dunger.weatherappandroidclient;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.Services.WeatherStationsService;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static GoogleMap mMap;

    static MapsActivity mapsActivity;
    private FusedLocationProviderClient mFusedLocationClient;

    //Debug variables
    private static final String TAG = MapsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapsActivity = this;
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

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

        WeatherStationsService weatherStationsService = new WeatherStationsService(MapsActivity.this);
        weatherStationsService.GetWeatherStations();

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(getApplicationContext(), WeatherCurrentActivity.class);
                intent.putExtra("station", marker.getTitle());
                startActivity(intent);
            }
        });
    }

    public void PopulateMapWithWeatherStations(WeatherStation[] stations) {
        if (stations != null) {
            for (WeatherStation x : stations) {
                Marker marker = mMap.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(x.getLatitude(), x.getLongitude()))
                                .title(x.getCityName())
                                .snippet(getResources().getString(R.string.currentWeatherLatitude) + x.getLatitude() + " | " + getResources().getString(R.string.currentWeatherLongitude) + x.getLongitude())
                );
            }

            //Move the camera to the user's location and zoom in
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Permission check
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.26,19.02), 8.0f));
                Toast.makeText(getApplicationContext(),
                        getString(R.string.GPSMissingPermissions_notification), Toast.LENGTH_SHORT).show();
            }
            else
            {
                mFusedLocationClient.getLastLocation()
                        .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                // Got last known location. In some rare situations this can be null.
                                if (location != null) {
                                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),location.getLongitude()), 8.0f));
                                }
                                else
                                {
                                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.26,19.02), 8.0f));
                                }
                            }
                        });
            }
        } else {
            Log.i(TAG, "\n\nStations==NULL");
        }
    }

    public static MapsActivity getInstance(){
        return mapsActivity;
    }

}
