package com.socrata.android.example.util;

import android.app.Application;
import android.location.Location;

public class App extends Application
{
    private Location lastLocation;
    private long lastLocationUpdateTime;

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }

    public long getLastLocationUpdateTime() {
        return lastLocationUpdateTime;
    }

    public void setLastLocationUpdateTime(long lastLocationUpdateTime) {
        this.lastLocationUpdateTime = lastLocationUpdateTime;
    }
}