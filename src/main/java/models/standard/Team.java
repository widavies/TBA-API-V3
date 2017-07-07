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
    private Double latitude;
    /**
     * Will be NULL, for future development.
     */
    private Double longitude;
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
}
