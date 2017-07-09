package models.standard;

import lombok.Data;
import models.other.events.Webcast;
import models.simple.SEvent;

/**
 * Events represent FIRST Robotics Competition events, both official and unofficial.
 * key_name is like '2010ct'
 *
 * This is the standard Event model, simple models can be found in models.simple
 *
 * This class is a child of SEvent.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class Event extends SEvent {

    /**
     * Same as name but doesn’t include event specifiers, such as ‘Regional’ or 'District’. May be null.
     */
    private String shortName;
    /**
     * Event Type, eg Regional, District, or Offseason.
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
     * Playoff Type, as defined here: https://github.com/the-blue-alliance/the-blue-alliance/blob/master/consts/playoff_type.py#L4, or null.
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


}
