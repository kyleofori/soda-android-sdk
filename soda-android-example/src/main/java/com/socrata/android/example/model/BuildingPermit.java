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

    @SodaField("permit_applied")
    private String permitApplied;

    @SodaField("permit_issued")
    private String permitIssued;

    @SodaField("permit_expires")
    private String permitExpires;

    @SodaField("site_address")
    private String siteAddress;

    @SodaField("between1")
    private String between1;

    @SodaField("parcel_no")
    private String parcelNo;

    @SodaField("lot_number")
    private String lotNumber;

    @SodaField("subdivision")
    private String subdivision;

    @SodaField("case_type")
    private String caseType;

    @SodaField("case_description")
    private String caseDescription;

    @SodaField("legal_use")
    private String legalUse;

    @SodaField("estimated_cost")
    private String estimatedCost;

    @SodaField("parcel_size")
    private String parcelSize;

    @SodaField("parcel_cluster_sector")
    private String parcelClusterSector;

    @SodaField("stories")
    private String stories;

    @SodaField("parcel_floor_area")
    private String parcelFloorArea;

    @SodaField("parcel_ground_area")
    private String parcelGroundArea;

    @SodaField("prc_aka_address")
    private String prcAkaAddress;

    @SodaField("bld_permit_type")
    private String bldPermitType;

    @SodaField("permit_description")
    private String permitDescription;

    @SodaField("bld_permit_desc")
    private String bldPermitDesc;

    @SodaField("bld_type_use")
    private String bldTypeUse;

    @SodaField("residential")
    private String residential;

    @SodaField("description")
    private String description;

    @SodaField("bld_type_const_cod")
    private String bldTypeConstCod;

    @SodaField("bld_zoning_dist")
    private String bldZoningDist;

    @SodaField("bld_use_group")
    private String bldUseGroup;

    @SodaField("bld_basement")
    private String bldBasement;

    @SodaField("fee_type")
    private String feeType;

    @SodaField("csm_caseno")
    private String csmCaseno;

    @SodaField("csf_created_by")
    private String csfCreatedBy;

    @SodaField("seq_no")
    private String seqNo;

    @SodaField("pcf_amt_pd")
    private String pcfAmtPd;

    @SodaField("pcf_amt_due")
    private String pcfAmtDue;

    @SodaField("pcf_updated")
    private String pcfUpdated;

    @SodaField("owner_last_name")
    private String ownerLastName;

    @SodaField("owner_first_name")
    private String ownerFirstName;

    @SodaField("owner_address1")
    private String ownerAddress1;

    @SodaField("owner_address2")
    private String ownerAddress2;

    @SodaField("owner_city")
    private String ownerCity;

    @SodaField("owner_state")
    private String ownerState;

    @SodaField("owner_zip")
    private String ownerZip;

    @SodaField("contractor_last_name")
    private String contractorLastName;

    @SodaField("contractor_first_name")
    private String contractorFirstName;

    @SodaField("contractor_address1")
    private String contractorAddress1;

    @SodaField("contractor_address2")
    private String contractorAddress2;

    @SodaField("contractor_city")
    private String contractorCity;

    @SodaField("contractor_state")
    private String contractorState;

    @SodaField("contractor_zip")
    private String contractorZip;

    @SodaField("condition_for_approval")
    private String conditionForApproval;

    @SodaField("site_location")
    private String siteLocation;

    @SodaField("owner_location")
    private String ownerLocation;

    @SodaField("contractor_location")
    private String contractorLocation;

    @SodaField("geom")
    private String geom;

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getPermitApplied() {
        return permitApplied;
    }

    public void setPermitApplied(String permitApplied) {
        this.permitApplied = permitApplied;
    }

    public String getPermitIssued() {
        return permitIssued;
    }

    public void setPermitIssued(String permitIssued) {
        this.permitIssued = permitIssued;
    }

    public String getPermitExpires() {
        return permitExpires;
    }

    public void setPermitExpires(String permitExpires) {
        this.permitExpires = permitExpires;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getBetween1() {
        return between1;
    }

    public void setBetween1(String between1) {
        this.between1 = between1;
    }

    public String getParcelNo() {
        return parcelNo;
    }

    public void setParcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public String getLegalUse() {
        return legalUse;
    }

    public void setLegalUse(String legalUse) {
        this.legalUse = legalUse;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getParcelSize() {
        return parcelSize;
    }

    public void setParcelSize(String parcelSize) {
        this.parcelSize = parcelSize;
    }

    public String getParcelClusterSector() {
        return parcelClusterSector;
    }

    public void setParcelClusterSector(String parcelClusterSector) {
        this.parcelClusterSector = parcelClusterSector;
    }

    public String getStories() {
        return stories;
    }

    public void setStories(String stories) {
        this.stories = stories;
    }

    public String getParcelFloorArea() {
        return parcelFloorArea;
    }

    public void setParcelFloorArea(String parcelFloorArea) {
        this.parcelFloorArea = parcelFloorArea;
    }

    public String getParcelGroundArea() {
        return parcelGroundArea;
    }

    public void setParcelGroundArea(String parcelGroundArea) {
        this.parcelGroundArea = parcelGroundArea;
    }

    public String getPrcAkaAddress() {
        return prcAkaAddress;
    }

    public void setPrcAkaAddress(String prcAkaAddress) {
        this.prcAkaAddress = prcAkaAddress;
    }

    public String getBldPermitType() {
        return bldPermitType;
    }

    public void setBldPermitType(String bldPermitType) {
        this.bldPermitType = bldPermitType;
    }

    public String getPermitDescription() {
        return permitDescription;
    }

    public void setPermitDescription(String permitDescription) {
        this.permitDescription = permitDescription;
    }

    public String getBldPermitDesc() {
        return bldPermitDesc;
    }

    public void setBldPermitDesc(String bldPermitDesc) {
        this.bldPermitDesc = bldPermitDesc;
    }

    public String getBldTypeUse() {
        return bldTypeUse;
    }

    public void setBldTypeUse(String bldTypeUse) {
        this.bldTypeUse = bldTypeUse;
    }

    public String getResidential() {
        return residential;
    }

    public void setResidential(String residential) {
        this.residential = residential;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBldTypeConstCod() {
        return bldTypeConstCod;
    }

    public void setBldTypeConstCod(String bldTypeConstCod) {
        this.bldTypeConstCod = bldTypeConstCod;
    }

    public String getBldZoningDist() {
        return bldZoningDist;
    }

    public void setBldZoningDist(String bldZoningDist) {
        this.bldZoningDist = bldZoningDist;
    }

    public String getBldUseGroup() {
        return bldUseGroup;
    }

    public void setBldUseGroup(String bldUseGroup) {
        this.bldUseGroup = bldUseGroup;
    }

    public String getBldBasement() {
        return bldBasement;
    }

    public void setBldBasement(String bldBasement) {
        this.bldBasement = bldBasement;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getCsmCaseno() {
        return csmCaseno;
    }

    public void setCsmCaseno(String csmCaseno) {
        this.csmCaseno = csmCaseno;
    }

    public String getCsfCreatedBy() {
        return csfCreatedBy;
    }

    public void setCsfCreatedBy(String csfCreatedBy) {
        this.csfCreatedBy = csfCreatedBy;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getPcfAmtPd() {
        return pcfAmtPd;
    }

    public void setPcfAmtPd(String pcfAmtPd) {
        this.pcfAmtPd = pcfAmtPd;
    }

    public String getPcfAmtDue() {
        return pcfAmtDue;
    }

    public void setPcfAmtDue(String pcfAmtDue) {
        this.pcfAmtDue = pcfAmtDue;
    }

    public String getPcfUpdated() {
        return pcfUpdated;
    }

    public void setPcfUpdated(String pcfUpdated) {
        this.pcfUpdated = pcfUpdated;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerAddress1() {
        return ownerAddress1;
    }

    public void setOwnerAddress1(String ownerAddress1) {
        this.ownerAddress1 = ownerAddress1;
    }

    public String getOwnerAddress2() {
        return ownerAddress2;
    }

    public void setOwnerAddress2(String ownerAddress2) {
        this.ownerAddress2 = ownerAddress2;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public String getOwnerState() {
        return ownerState;
    }

    public void setOwnerState(String ownerState) {
        this.ownerState = ownerState;
    }

    public String getOwnerZip() {
        return ownerZip;
    }

    public void setOwnerZip(String ownerZip) {
        this.ownerZip = ownerZip;
    }

    public String getContractorLastName() {
        return contractorLastName;
    }

    public void setContractorLastName(String contractorLastName) {
        this.contractorLastName = contractorLastName;
    }

    public String getContractorFirstName() {
        return contractorFirstName;
    }

    public void setContractorFirstName(String contractorFirstName) {
        this.contractorFirstName = contractorFirstName;
    }

    public String getContractorAddress1() {
        return contractorAddress1;
    }

    public void setContractorAddress1(String contractorAddress1) {
        this.contractorAddress1 = contractorAddress1;
    }

    public String getContractorAddress2() {
        return contractorAddress2;
    }

    public void setContractorAddress2(String contractorAddress2) {
        this.contractorAddress2 = contractorAddress2;
    }

    public String getContractorCity() {
        return contractorCity;
    }

    public void setContractorCity(String contractorCity) {
        this.contractorCity = contractorCity;
    }

    public String getContractorState() {
        return contractorState;
    }

    public void setContractorState(String contractorState) {
        this.contractorState = contractorState;
    }

    public String getContractorZip() {
        return contractorZip;
    }

    public void setContractorZip(String contractorZip) {
        this.contractorZip = contractorZip;
    }

    public String getConditionForApproval() {
        return conditionForApproval;
    }

    public void setConditionForApproval(String conditionForApproval) {
        this.conditionForApproval = conditionForApproval;
    }

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public String getOwnerLocation() {
        return ownerLocation;
    }

    public void setOwnerLocation(String ownerLocation) {
        this.ownerLocation = ownerLocation;
    }

    public String getContractorLocation() {
        return contractorLocation;
    }

    public void setContractorLocation(String contractorLocation) {
        this.contractorLocation = contractorLocation;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}
