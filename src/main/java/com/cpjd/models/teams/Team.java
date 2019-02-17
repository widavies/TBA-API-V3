package com.cpjd.models.teams;

/**
 * The standard team model
 *
 * Extends the simple team model
 */

public class Team extends STeam {
    /**
     * Will be NULL, for future development.
     */
    private String address;
    /**
     * Postal code from the team address.
     */
    private String postalCode;
    /**
     * Will be NULL, for future development.
     */
    private String GMAPSPlaceID;
    /**
     * Will be NULL, for future development.
     */
    private String GMAPURL;
    /**
     * Will be NULL, for future development.
     */
    private double latitude;
    /**
     * Will be NULL, for future development.
     */
    private double longitude;
    /**
     * Will be NULL, for future development.
     */
    private String locationName;
    /**
     * Official website associated with the team.
     */
    private String website;
    /**
     * First year the team officially competed.
     */
    private long rookieYear;
    /**
     * Team’s motto as provided by FIRST.
     */
    private String motto;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getGMAPSPlaceID() {
        return GMAPSPlaceID;
    }

    public void setGMAPSPlaceID(String GMAPSPlaceID) {
        this.GMAPSPlaceID = GMAPSPlaceID;
    }

    public String getGMAPURL() {
        return GMAPURL;
    }

    public void setGMAPURL(String GMAPURL) {
        this.GMAPURL = GMAPURL;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getRookieYear() {
        return rookieYear;
    }

    public void setRookieYear(long rookieYear) {
        this.rookieYear = rookieYear;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }
}
