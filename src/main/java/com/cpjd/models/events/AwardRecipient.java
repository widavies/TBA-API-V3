package com.cpjd.models.events;

import java.io.Serializable;

/**
 * An Award_Recipient object represents the team and/or person who received an award at an event.
 */
public class AwardRecipient implements Serializable {
    /**
     * The TBA team key for the team that was given the award. May be null.
     */
    private String teamKey;
    /**
     * The name of the individual given the award. May be null.
     */
    private String awardee;

    public String getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(String teamKey) {
        this.teamKey = teamKey;
    }

    public String getAwardee() {
        return awardee;
    }

    public void setAwardee(String awardee) {
        this.awardee = awardee;
    }
}
