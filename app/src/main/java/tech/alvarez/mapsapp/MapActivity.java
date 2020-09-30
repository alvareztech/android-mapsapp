package tech.alvarez.mapsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.huawei.hms.maps.HuaweiMap;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, com.huawei.hms.maps.OnMapReadyCallback {

    private GoogleMap googleMap;
    private HuaweiMap huaweiMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

        com.huawei.hms.maps.SupportMapFragment map2Fragment = (com.huawei.hms.maps.SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.huaweiMap);
        map2Fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng sydney = new LatLng(-34, 151);
        this.googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onMapReady(HuaweiMap huaweiMap) {
        this.huaweiMap = huaweiMap;

        com.huawei.hms.maps.model.LatLng sydney = new com.huawei.hms.maps.model.LatLng (-34, 151);
        this.huaweiMap.addMarker(new com.huawei.hms.maps.model.MarkerOptions().position(sydney).title("Hello"));
        this.huaweiMap.moveCamera(com.huawei.hms.maps.CameraUpdateFactory.newLatLng(sydney));
    }
}