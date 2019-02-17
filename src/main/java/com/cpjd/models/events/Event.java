package com.cpjd.models.events;

/**
 * Events represent FIRST Robotics Competition events, both official and unofficial.
 * key_name is like '2010ct'
 *
 * This is the standard Event model, simple models can be found in com.cpjd.models.simple
 *
 * This class is a child of SEvent.
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class Event extends SEvent {

    /**
     * Same as name but doesn’t include event specifiers, such as ‘Regional’ or 'District’. May be null.
     */
    private String shortName;
    /**
     * Event SortingType, eg Regional, District, or Offseason.
     */
    private String eventTypeString;
    /**
     * The event’s website, if any.
     */
    private String website;
    /**
     * The FIRST internal Event ID, used to link to the event on the FRC webpage.
     */
    private String firstEventID;
    /**
     * The TBA Event key that represents the event’s parent. Used to link back to the event from a division event. It is also the inverse relation of divison_keys.
     */
    private String parentEventkey;
    /**
     * Playoff SortingType, as defined here: https://github.com/the-blue-alliance/the-blue-alliance/blob/master/consts/playoff_type.py#L4, or null.
     */
    private long playoffType;
    /**
     * String representation of the playoff_type, or null.
     */
    private String playoffTypeString;
    /**
     * An array of event keys for the divisions at this event.
     */
    private String[] divisonKeys;

    /**
     * City, town, village, etc. the event is located in.
     */
    private String city;
    /**
     * Address of the event’s venue, if available.
     */
    private String address;
    /**
     * Postal code from the event address.
     */
    private String postalCode;
    /**
     * Google Maps Place ID for the event address.
     */
    private String GMAPSPlaceID;
    /**
     * Link to address location on Google Maps.
     */
    private String GMAPSURL;
    /**
     * Latitude for the event address.
     */
    private double latitude;
    /**
     * Longitude for the event address.
     */
    private double longitude;
    /**
     * Name of the location at the address for the event, eg. Blue Alliance High School.
     */
    private String locationName;
    /**
     * Week of the competition season this event is in.
     */
    private long week;
    /**
     * Timezone name.
     */
    private String timezone;

    /**
     * An array of webcasts this event contains
     */
    private Webcast[] webcasts;


    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getEventTypeString() {
        return eventTypeString;
    }

    public void setEventTypeString(String eventTypeString) {
        this.eventTypeString = eventTypeString;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFirstEventID() {
        return firstEventID;
    }

    public void setFirstEventID(String firstEventID) {
        this.firstEventID = firstEventID;
    }

    public String getParentEventkey() {
        return parentEventkey;
    }

    public void setParentEventkey(String parentEventkey) {
        this.parentEventkey = parentEventkey;
    }

    public long getPlayoffType() {
        return playoffType;
    }

    public void setPlayoffType(long playoffType) {
        this.playoffType = playoffType;
    }

    public String getPlayoffTypeString() {
        return playoffTypeString;
    }

    public void setPlayoffTypeString(String playoffTypeString) {
        this.playoffTypeString = playoffTypeString;
    }

    public String[] getDivisonKeys() {
        return divisonKeys;
    }

    public void setDivisonKeys(String[] divisonKeys) {
        this.divisonKeys = divisonKeys;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public String getGMAPSURL() {
        return GMAPSURL;
    }

    public void setGMAPSURL(String GMAPSURL) {
        this.GMAPSURL = GMAPSURL;
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

    public long getWeek() {
        return week;
    }

    public void setWeek(long week) {
        this.week = week;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Webcast[] getWebcasts() {
        return webcasts;
    }

    public void setWebcasts(Webcast[] webcasts) {
        this.webcasts = webcasts;
    }
}
