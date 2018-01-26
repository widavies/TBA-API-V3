package models.other.teams.status;

import lombok.Data;
import models.other.WLTRecord;

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
    private WLTRecord record;
    /**
     * Record in current level of competition (e.g. QF, SF, F) as a string in the format WINS-LOSSES-TIES.
     */
    private WLTRecord currentLevelRecord;
    /**
     * Current competition status for the playoffs.
     */
    private String status;
    /**
     * The average match score during playoffs. Year specific. May be null if not relevant for a given year.
     */
    private Long playoffAverage;
}
