package com.example.anon.googlemapsdemo;

import com.google.android.gms.maps.model.LatLng;

public class ObjectOnMap {
    private String name;
    private String phone;
    private String facebook;
    private int avatar;
    private LatLng locate;

    public ObjectOnMap(String n, String ph, String f, int ava, LatLng l) {
        name = n;
        phone = ph;
        facebook = f;
        avatar = ava;
        locate = new LatLng(l.latitude, l.longitude);
    }

    public ObjectOnMap(ObjectOnMap oom) {
        name = oom.getName();
        phone = oom.getPhone();
        facebook = oom.getFacebook();
        avatar = oom.getAvatar();
        locate = oom.getLocate();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public int getAvatar() {
        return avatar;
    }

    public LatLng getLocate() {
        return new LatLng(locate.latitude, locate.longitude);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setLocate(LatLng locate) {
        this.locate = new LatLng(locate.latitude, locate.longitude);
    }
}
