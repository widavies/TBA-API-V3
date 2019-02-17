package com.cpjd.models.teams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The standard team model
 *
 * Extends the simple team model
 */

@EqualsAndHashCode(callSuper = false)
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
}
