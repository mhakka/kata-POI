package com.mha.poi.model;


public class Area {
    
    private float minLatitude;
    private float maxLatitude;
    private float minLogitude;
    private float maxLongitude;
    private long density;

    public Area(float minLatitude, float maxLatitude, float minLogitude, float maxLongitude) {
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLogitude = minLogitude;
        this.maxLongitude = maxLongitude;
    }

    public float getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(float minLatitude) {
        this.minLatitude = minLatitude;
    }

    public float getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(float maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public float getMinLogitude() {
        return minLogitude;
    }

    public void setMinLogitude(float minLogitude) {
        this.minLogitude = minLogitude;
    }

    public float getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(float maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    public long getDensity() {
        return density;
    }

    public void setDensity(long density) {
        this.density = density;
    }
    
    public void incrementDensity() {
        this.density++;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Float.floatToIntBits(this.minLatitude);
        hash = 31 * hash + Float.floatToIntBits(this.maxLatitude);
        hash = 31 * hash + Float.floatToIntBits(this.minLogitude);
        hash = 31 * hash + Float.floatToIntBits(this.maxLongitude);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Area other = (Area) obj;
        if (Float.floatToIntBits(this.minLatitude) != Float.floatToIntBits(other.minLatitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.maxLatitude) != Float.floatToIntBits(other.maxLatitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.minLogitude) != Float.floatToIntBits(other.minLogitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.maxLongitude) != Float.floatToIntBits(other.maxLongitude)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Area{" + "minLatitude=" + minLatitude + ", maxLatitude=" + maxLatitude + 
                ", minLogitude=" + minLogitude + ", maxLongitude=" + maxLongitude + ", density=" + density + '}';
    }
       
}
