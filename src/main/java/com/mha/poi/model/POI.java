package com.mha.poi.model;


public class POI {
    
    private String id;
    private float longitude;
    private float latitude;

    public POI(String id, float longitude, float latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "POI{" + "id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + '}';
    }
 
}
