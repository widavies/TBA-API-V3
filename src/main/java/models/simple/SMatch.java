package models.simple;

import lombok.Data;
import models.other.matches.MatchAlliance;
import models.standard.Match;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class SMatch implements Serializable, Comparable<SMatch> {
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
    private long setNumber;
    /**
     * The match number of the match in the competition level.
     */
    private long matchNumber;
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
    private long time;
    /**
     * UNIX timestamp (seconds since 1-Jan-1970 00:00:00) of the TBA predicted match start time.
     */
    private long predictedTime;
    /**
     * UNIX timestamp (seconds since 1-Jan-1970 00:00:00) of actual match start time.
     */
    private long actualTime;

    /**
     * Sorts matches by:
     * -Quals
     * -Quarters
     * -Semis
     * -Finals
     */

    @Override
    public int compareTo(SMatch o) {
        long localScore = matchNumber;
        if(compLevel.equals("qf")) localScore += 1000;
        else if(compLevel.equals("sf")) localScore += 10000;
        else if(compLevel.equals("f")) localScore += 100000;
        localScore += matchNumber;

        long compareScore = o.getMatchNumber();
        if(o.getCompLevel().equals("qf")) compareScore += 1000;
        else if(o.getCompLevel().equals("sf")) compareScore += 10000;
        else if(o.getCompLevel().equals("f")) compareScore += 100000;
        compareScore += o.getMatchNumber();

        return Long.compare(localScore, compareScore);
    }
}
