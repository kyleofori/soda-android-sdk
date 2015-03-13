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

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.socrata.android.client.Consumer;
import com.socrata.android.example.R;
import com.socrata.android.example.model.BuildingPermit;
import com.socrata.android.example.views.BuildingPermitView;
import com.socrata.android.soql.Query;
import com.socrata.android.soql.clauses.Expression;
import com.socrata.android.ui.list.SodaListActivity;

/**
 * A simple list activity displaying earthquakes results from the Soda API.
 * Showcases the use of the SodaListActivity component
 */
//public class ListViewExampleActivity extends SodaListActivity<EarthquakeView, Earthquake> {
public class ListViewExampleActivity extends SodaListActivity<BuildingPermitView, BuildingPermit> {

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

        Query query = new Query("cthr-59vy", BuildingPermit.class);
        Expression ex = Expression.eq("description", "'Vacant Lot'");
        query.addWhere(ex);
        return query;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }
}
