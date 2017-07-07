package models.standard;

import lombok.Data;
import models.simple.STeam;

import java.util.HashMap;

/**
 * The standard team model
 *
 * Extends the simple team model
 */
@Data
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
    private int latitude;
    /**
     * Will be NULL, for future development.
     */
    private int longitude;
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
    private int rookieYear;
    /**
     * Team’s motto as provided by FIRST.
     */
    private String motto;
    /**
     *
     Location of the team’s home championship each year as a key-value pair. The year (as a string) is the key, and the city is the value.
     */
    private HashMap<Integer, String> homeChampionship;
}
