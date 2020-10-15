package tech.alvarez.mapsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
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

        MapFragment googleMapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.googleMap);
        googleMapFragment.getMapAsync(this);

        com.huawei.hms.maps.MapFragment huaweiMapFragment = (com.huawei.hms.maps.MapFragment) getFragmentManager()
                .findFragmentById(R.id.huaweiMap);
        huaweiMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng officePosition = new LatLng(-17.760294, -63.201106);

        MarkerOptions markerOptions = new MarkerOptions()
                .position(officePosition)
                .title("Huawei Bolivia Office")
                .snippet("Av. Las Ramblas #100, Edificio Tropical Tours, 3er piso");

        this.googleMap.addMarker(markerOptions);
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(officePosition));
    }

    @Override
    public void onMapReady(HuaweiMap huaweiMap) {
        this.huaweiMap = huaweiMap;

        com.huawei.hms.maps.model.LatLng officePosition = new com.huawei.hms.maps.model.LatLng(-17.760294, -63.201106);

        com.huawei.hms.maps.model.MarkerOptions markerOptions = new com.huawei.hms.maps.model.MarkerOptions()
                .position(officePosition)
                .title("Huawei Bolivia Office")
                .snippet("Av. Las Ramblas #100, Edificio Tropical Tours, 3er piso");

        this.huaweiMap.addMarker(markerOptions);
        this.huaweiMap.moveCamera(com.huawei.hms.maps.CameraUpdateFactory.newLatLng(officePosition));
    }

    public static boolean isGMSAvailable(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == ConnectionResult.SUCCESS;
    }
}