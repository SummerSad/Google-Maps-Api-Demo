package com.example.anon.googlemapsdemo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

class CustomInfoMarker implements GoogleMap.InfoWindowAdapter {
    private Context context;
    LayoutInflater inflater;

    public CustomInfoMarker(Context c) {
        context = c;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.info_marker, null);

        ImageView tvAvatar = view.findViewById(R.id.avatarMarker);
        TextView tvName = view.findViewById(R.id.nameMarker);
        TextView tvPhone = view.findViewById(R.id.phoneMarker);

        // get tag
        ObjectOnMap oom = (ObjectOnMap) (marker.getTag());
        tvAvatar.setImageResource(oom.getAvatar());
        tvName.setText(oom.getName());
        tvPhone.setText("SDT: " + oom.getPhone());

        return view;
    }
}
