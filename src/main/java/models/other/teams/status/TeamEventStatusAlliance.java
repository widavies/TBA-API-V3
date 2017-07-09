package models.other.teams.status;

import lombok.Data;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class TeamEventStatusAlliance {
    /**
     * Alliance name, may be null.
     */
    private String name;
    /**
     * Alliance number.
     */
    private int number;
    /**
     * Backup status, may be null.
     */
    private TeamEventStatusAllianceBackup backup;
    /**
     * Order the team was picked in the alliance from 0-2, with 0 being alliance captain.
     */
    private int pick;
}
