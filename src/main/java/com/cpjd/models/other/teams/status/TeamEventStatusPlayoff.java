package com.cpjd.models.other.teams.status;

import lombok.Data;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class TeamEventStatusPlayoff {
    /**
     * The highest playoff level the team reached.
     */
    private String level;
    /**
     * Record in playoffs as a string in the format WINS-LOSSES-TIES.
     */
    private String record;
    /**
     * Current competition status for the playoffs.
     */
    private String[] status;
}
