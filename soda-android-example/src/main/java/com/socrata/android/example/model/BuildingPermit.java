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

package com.socrata.android.example.model;

import com.socrata.android.client.SodaEntity;
import com.socrata.android.client.SodaField;

/**
 * Model entity representing a remote record on the Soda sample datasets
 * http://dev.socrata.com/consumers/getting-started
 *
 * All Soda entities are annotated with @SodaEntity for automatic serialization of json responses
 * into domain model objects
 */
@SodaEntity
public class BuildingPermit {

    @SodaField("permit_no")
    private String permitNumber;

    @SodaField("site_address")
    private String siteAddress;

    @SodaField("description")
    private String description;

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
