package com.socrata.android.example.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.socrata.android.example.R;

public class SplashLocationActivity extends Activity {

    private static final int SPLASH_DELAY = 2000;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 2323;
    
    private AlertDialog gpsAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        checkForPlayServices();
    }


    @Override
    protected void onResume() {
        super.onResume();
        checkLocationServices();
    }
    
    public void checkForPlayServices() {
        int googlePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (googlePlayServicesAvailable != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(googlePlayServicesAvailable)) {
                GooglePlayServicesUtil.getErrorDialog(googlePlayServicesAvailable, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST, new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialogInterface) {
                                finish();
                            }
                        }).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PLAY_SERVICES_RESOLUTION_REQUEST) {
            if(resultCode == RESULT_OK) {
                checkLocationServices();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, R.string.google_play_services_should_be_installed,
                        Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, R.string.google_play_services_should_be_installed,
                        Toast.LENGTH_SHORT).show();
                finish();
            }
            return;
        }
    }

    protected void checkLocationServices() {
        if (isLocationEnabled()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashLocationActivity.this, ListViewExampleActivity.class);
                    startActivity(i);
                    finish();
                }
            }, SPLASH_DELAY);
        } else {
            showLocationServicesDialog();
        }
    }

    protected boolean isLocationEnabled() {
        int locationMode = 0;
        String locationProviders;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                locationMode = Settings.Secure.getInt(getContentResolver(), Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;
        } else {
            locationProviders = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }
    }

    protected void showLocationServicesDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.gps_not_found_title);  // GPS not found
        builder.setMessage(R.string.gps_not_found_message); // Want to enable?
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                checkLocationServices();
            }
        });
        gpsAlertDialog = builder.create();
        gpsAlertDialog.show();
    }
}
