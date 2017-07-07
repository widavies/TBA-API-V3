package models.other;

import lombok.Data;

/**
 * An Award_Recipient object represents the team and/or person who received an award at an event.
 */
@Data
public class AwardRecipient {
    /**
     * The TBA team key for the team that was given the award. May be null.
     */
    private String teamKey;
    /**
     * The name of the individual given the award. May be null.
     */
    private String awardee;
}
