package com.example.anon.googlemapsdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<ObjectOnMap> objectOnMaps;
    private LatLng cur_locate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // Set friends data
        objectOnMaps = new ArrayList<>();
        setData();
    }

    private void setData() {
        ObjectOnMap oom_thanh = new ObjectOnMap("Nguyen Duy Thanh",
                "0123456789",
                "https://www.facebook.com/profile.php?id=100009407612046",
                R.drawable.thanh,
                new LatLng(10.772068, 106.704402));
        objectOnMaps.add(oom_thanh);

        ObjectOnMap oom_nam = new ObjectOnMap("Tran Hoai Nam",
                "0123456789",
                "https://www.facebook.com/tran.hoainam.1610",
                R.drawable.nam,
                new LatLng(10.779483, 106.699168));
        objectOnMaps.add(oom_nam);

        ObjectOnMap oom_loc = new ObjectOnMap("Nguyen Buu Loc",
                "0123456789",
                "https://www.facebook.com/buulockg",
                R.drawable.loc,
                new LatLng(10.766294, 106.638876));
        objectOnMaps.add(oom_loc);

        ObjectOnMap oom_thuc = new ObjectOnMap("Nguyen Chi Thuc",
                "0123456789",
                "https://www.facebook.com/chi.thuc.1998",
                R.drawable.thuc,
                new LatLng(10.751637, 106.683803));
        objectOnMaps.add(oom_thuc);

        ObjectOnMap oom_huan = new ObjectOnMap("Ho Minh Huan",
                "0123456789",
                "https://www.facebook.com/minhhuan.ho.9",
                R.drawable.huan,
                new LatLng(10.799252, 106.686838));
        objectOnMaps.add(oom_huan);

        ObjectOnMap oom_cuong = new ObjectOnMap("Mai Chi Cuong",
                "0123456789",
                "https://www.facebook.com/profile.php?id=100005092231986",
                R.drawable.cuong,
                new LatLng(10.755763, 106.678703));
        objectOnMaps.add(oom_cuong);

        ObjectOnMap oom_dai = new ObjectOnMap("Le Bao Dai",
                "0123456789",
                "https://www.facebook.com/baodai.2611",
                R.drawable.dai,
                new LatLng(10.799055, 106.677985));
        objectOnMaps.add(oom_dai);

        ObjectOnMap oom_nhut = new ObjectOnMap("Le Nhut",
                "0123456789",
                "https://www.facebook.com/LNhut98",
                R.drawable.nhut,
                new LatLng(10.774719, 106.659782));
        objectOnMaps.add(oom_nhut);

        ObjectOnMap oom_hcmus = new ObjectOnMap("HCMUS",
                "0123456789",
                "www.hcmus.edu.vn",
                R.drawable.hcmus,
                new LatLng(10.759590, 106.684114));
        objectOnMaps.add(oom_hcmus);
        cur_locate = oom_hcmus.getLocate();
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

        // Add object on maps, like friends or places
        for (ObjectOnMap oom : objectOnMaps) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(oom.getLocate());
            markerOptions.title(oom.getName());

            // set icon
            Bitmap bitmap = scaleBitmapFromDrawable(oom.getAvatar());
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));

            Marker m = mMap.addMarker(markerOptions);

            // set tag
            m.setTag(new ObjectOnMap(oom));
        }

        // set camera
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cur_locate, 13.5f));

        /* 1: World
         * 5: Landmass/continent
         * 10: City
         * 15: Streets
         * 20: Buildings
         */
        mMap.setMinZoomPreference(6.0f);
        mMap.setMaxZoomPreference(18.0f);

        // add zoom in, zoom out button
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // set custom info window
        CustomInfoMarker customInfoMarker = new CustomInfoMarker(this);
        mMap.setInfoWindowAdapter(customInfoMarker);

    }

    private Bitmap scaleBitmapFromDrawable(int id_avatar) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id_avatar);
        return Bitmap.createScaledBitmap(bitmap, 80, 80, false);
    }
}
