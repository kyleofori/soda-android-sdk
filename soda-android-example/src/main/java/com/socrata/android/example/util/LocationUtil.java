package com.socrata.android.example.util;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.Date;


public class LocationUtil implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public static final String TAG = LocationUtil.class.getName();

    public static final int LOCATION_INTERVAL = 60 * 1000;
    public static final int LOCATION_FASTEST_INTERVAL = 5 * 1000;
    public static final int LOCATION_EXPIRE_TIME = 10 * 60 * 1000;
    public static final int LOCATION_TIMEOUT = 10 * 1000;


    public interface DetroitLocationListener {
        public void gotLocation(Location location);
    }

    private DetroitLocationListener detroitLocationListener;
    private GoogleApiClient googleApiClient;

    private Location lastLocation;
    private long lastLocationUpdateTime;

    private Handler myHandler = new Handler();

    private Runnable locationTimeoutRunnable = new Runnable() {
        public void run() {
            Log.d(TAG, "in run: CALLING STOP LOCATION UPDATES");
            stopLocationUpdates();
//            EventBus.getDefault().post(new ErrorMessageEvent("Could not find location."));
        }
    };


    public LocationUtil(Context context) {
        googleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    public void connect() {
        Log.d(TAG, "in connect: ENTER");
        if (locationExpired()) {
            Log.d(TAG, "in connect: LOCATION WAS EXPIRED. CALLING googleApiClient.connect()");
            googleApiClient.connect();
        }
    }

    public void disconnect() {
        googleApiClient.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d(TAG, "in onConnected: ");
        startLocationUpdates();
    }

    private void startLocationUpdates() {
        // Set up a timeout to cancel location updates if its taking too long.
        myHandler.postDelayed(locationTimeoutRunnable, LOCATION_TIMEOUT);
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, createLocationRequest(), this);
    }

    private void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        myHandler.removeCallbacks(locationTimeoutRunnable);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "in onConnectionSuspended: ");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e(TAG, "in onConnectionFailed: ");
        Log.e(TAG, connectionResult.toString());
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.d(TAG, "in onLocationChanged: location now:" + location);
        Log.d(TAG, "in onLocationChanged: CALLED AT:" + new Date());
        if (location != null) {

            this.lastLocation = location;
            this.lastLocationUpdateTime = new Date().getTime();


            if (detroitLocationListener != null) {
                detroitLocationListener.gotLocation(lastLocation);
            }

            stopLocationUpdates();
        }
    }



    public void setDetroitLocationListener(DetroitLocationListener wiggyLocationListener) {
        this.detroitLocationListener = wiggyLocationListener;
    }

    public boolean hasLocation() {
        return lastLocation != null;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public long getLastLocationUpdateTime() {
        return lastLocationUpdateTime;
    }

    public boolean locationExpired() {
        return lastLocation == null || (new Date().getTime() - lastLocationUpdateTime) > LOCATION_EXPIRE_TIME;
    }

    public String getLastLocationString() {
        if (lastLocation != null) {
            return String.valueOf(lastLocation.getLatitude() + ":" + String.valueOf(lastLocation.getLongitude()));
        }
        return null;
    }

    public static String getStringForLocation(Location loc) {
        return String.valueOf(loc.getLatitude() + ":" + String.valueOf(loc.getLongitude()));
    }

    private LocationRequest createLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(LOCATION_INTERVAL);
        locationRequest.setFastestInterval(LOCATION_FASTEST_INTERVAL);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return locationRequest;
    }
}
