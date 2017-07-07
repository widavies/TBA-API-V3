package models.simple;

import lombok.Data;
import models.other.matches.MatchAlliance;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class SMatch {
    /**
     * TBA event key with the format yyyy[EVENT_CODE]_[COMP_LEVEL]m[MATCH_NUMBER], where yyyy is the year, and EVENT_CODE is the event code of the event, COMP_LEVEL is (qm, ef, qf, sf, f), and MATCH_NUMBER is the match number in the competition level. A set number may append the competition level if more than one match in required per set.
     *
     */
    private String key;
    /**
     * The competition level the match was played at.
     */
    private String compLevel;
    /**
     * The set number in a series of matches where more than one match is required in the match series.
     */
    private int setNumber;
    /**
     * The match number of the match in the competition level.
     */
    private int matchNumber;
    /**
     * A list of alliances, the teams on the alliances, and their score.
     */
    private MatchAlliance blue;
    /**
     * A list of alliances, the teams on the alliances, and their score.
     */
    private MatchAlliance red;
    /**
     * The color (red/blue) of the winning alliance. Will contain an empty string in the event of no winner, or a tie.
     */
    private String winningAlliance;
    /**
     * Event key of the event the match was played at.
     */
    private String eventKey;
    /**
     * UNIX timestamp (seconds since 1-Jan-1970 00:00:00) of the scheduled match time, as taken from the published schedule.
     */
    private int time;
    /**
     * UNIX timestamp (seconds since 1-Jan-1970 00:00:00) of the TBA predicted match start time.
     */
    private int predictedTime;
    /**
     * UNIX timestamp (seconds since 1-Jan-1970 00:00:00) of actual match start time.
     */
    private int actualTime;
}
