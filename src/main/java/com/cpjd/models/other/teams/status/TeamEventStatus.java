package com.cpjd.models.other.teams.status;

import lombok.Data;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class TeamEventStatus {
    private TeamEventStatusRank qual;
    private TeamEventStatusAlliance alliance;
    private TeamEventStatusPlayoff playoff;
    /**
     * An HTML formatted string suitable for display to the user containing the team’s alliance pick status.
     */
    private String allianceStatus;
    /**
     * An HTML formatter string suitable for display to the user containing the team’s playoff status.
     */
    private String playoffStatus;
    /**
     * An HTML formatted string suitable for display to the user containing the team’s overall status summary of the event.
     */
    private String overallStatus;

}
