/*
 * SODA Android SDK - Socrata, Inc
 *
 * Copyright (C) 2013 Socrata, Inc
 * All rights reserved.
 *
 * Developed for Socrata, Inc by:
 * 47 Degrees, LLC
 * http://47deg.com
 * hello@47deg.com
 */

package com.socrata.android.example.activities;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.socrata.android.client.Consumer;
import com.socrata.android.example.R;
import com.socrata.android.example.model.BuildingPermit;
import com.socrata.android.example.util.App;
import com.socrata.android.example.views.BuildingPermitView;
import com.socrata.android.soql.Query;
import com.socrata.android.soql.clauses.Expression;
import com.socrata.android.soql.datatypes.GeoBox;
import com.socrata.android.ui.list.SodaListActivity;

/**
 * A simple list activity displaying earthquakes results from the Soda API.
 * Showcases the use of the SodaListActivity component
 */
//public class ListViewExampleActivity extends SodaListActivity<EarthquakeView, Earthquake> {
public class ListViewExampleActivity extends SodaListActivity<BuildingPermitView, BuildingPermit> {
    
//    public static final double FIFTY_METER_OFFSET = 0.00566;
    public static final double FIFTY_METER_OFFSET = 0.1;

    private Consumer consumer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        consumer = new Consumer(getString(R.string.soda_domain));
        //new Consumer(getString(R.string.soda_domain), getString(R.string.soda_token));
        super.onCreate(savedInstanceState);
    }

    @Override
    public Consumer getConsumer() {
        return consumer;
    }

    @Override
    public Query getQuery() {
//        Query query = new Query("earthquakes", Earthquake.class);
//        query.addWhere(gt("magnitude", "2.0"));
//        query.addOrder(order("magnitude", OrderDirection.DESC));
//        return query;

        Location location = ((App)getApplication()).getLastLocation();
        
        double north = location.getLatitude() + FIFTY_METER_OFFSET;
        double south = location.getLatitude() - FIFTY_METER_OFFSET;
        double east = location.getLongitude() - FIFTY_METER_OFFSET;
        double west = location.getLongitude() + FIFTY_METER_OFFSET;
        
        Query query = new Query("cthr-59vy", BuildingPermit.class);
        Expression ex = Expression.withinBox("site_location", new GeoBox(north, east, south, west));
        query.addWhere(ex);
        return query;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }
}
