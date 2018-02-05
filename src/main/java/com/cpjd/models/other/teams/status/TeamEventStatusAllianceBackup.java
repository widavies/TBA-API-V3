package com.cpjd.models.other.teams.status;

import lombok.Data;

/**
 * Backup status, may be null.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class TeamEventStatusAllianceBackup {
    /**
     * TBA key for the team replaced by the backup.
     */
    private String out;
    /**
     * TBA key for the backup team called in.
     */
    private String in;
}
