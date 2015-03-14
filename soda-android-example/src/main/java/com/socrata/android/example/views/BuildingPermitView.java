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

package com.socrata.android.example.views;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.socrata.android.example.R;
import com.socrata.android.example.model.BuildingPermit;
import com.socrata.android.example.util.App;
import com.socrata.android.soql.datatypes.Location;
import com.socrata.android.ui.list.BindableView;
import com.socrata.android.ui.list.SodaHolder;

/**
 * @SodaHolder auto implements the view holder pattern for reusable cell instances in list views
 */
@SodaHolder(layout = "building_permit_item")
public class BuildingPermitView implements BindableView<BuildingPermit> {

    private TextView permit_no;

    private TextView site_address;

    private TextView description;
    
    private TextView distance;
    
    private android.location.Location androidLocation;
    
    @Override
    public void createViewHolder(View convertView) {
        permit_no = (TextView) convertView.findViewById(R.id.building_permit_permit_no);
        site_address = (TextView) convertView.findViewById(R.id.building_permit_site_address);
        description = (TextView) convertView.findViewById(R.id.building_permit_description);
        distance = (TextView) convertView.findViewById(R.id.building_permit_distance);
    }

    @Override
    public void bindView(BuildingPermit item, int position, View convertView, ViewGroup parent) {
        permit_no.setText(convertView.getContext().getString(R.string.permit_number, item.getPermitNumber()));
        site_address.setText(convertView.getContext().getString(R.string.site_address, item.getSiteAddress()));
        description.setText(convertView.getContext().getString(R.string.description, item.getDescription()));
        
//        TODO extract location from item
//        Location buildingLocation = item.getBuildingLocation();
//        office location: 42.3305308,-83.0468766
        
        // Note: this Location is of soda type
        Location location = new Location();
        location.setLatitude(42.3305308);
        location.setLongitude(-83.0468766);

        if (androidLocation == null) {
            App app = (App) convertView.getContext().getApplicationContext();
            androidLocation = app.getLastLocation();
        }

        String distanceInMeters = distanceInMeters(androidLocation.getLatitude(),
                                                   androidLocation.getLongitude(), 
                                                   location.getLatitude().doubleValue(), 
                                                   location.getLongitude().doubleValue());
        String result = convertView.getContext().getString(R.string.distance, distanceInMeters);
        distance.setText(result);
    }
    
    private String distanceInMeters(double androidLatitude, double androidLongitude, double latitude, double longitude) {
        float[] results = new float[3];
        android.location.Location.distanceBetween(androidLatitude, androidLongitude, latitude, longitude, results);
        return String.format("%.2f", results[0]);
    }
}
