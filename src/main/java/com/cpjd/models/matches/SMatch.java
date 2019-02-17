package com.cpjd.models.matches;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @since 1.0.0
 * @author Will Davies
 */
public class SMatch extends Sortable<SMatch> implements Serializable {
    /**
     * TBA event key with the format yyyy[EVENT_CODE]_[COMP_LEVEL]m[MATCH_NUMBER], where yyyy is the year, and EVENT_CODE is the event code of the event, COMP_LEVEL is (qm, ef, qf, sf, f), and MATCH_NUMBER is the match number in the competition level. A set number may append the competition level if more than one match in required per set.
     *
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

    @Override
    public int sort(SortingType type, boolean ascending, SMatch t2) {
        if(type == SortingType.DEFAULT || type == SortingType.NUMBER) {
            /*
             * Sorts matches by:
             * -Quals
             * -Quarters
             * -Semis
             * -Finals
             */
            String comp1 = compLevel;
            String comp2 = t2.getCompLevel();

            HashMap<String, Integer> map = new HashMap<>();
            map.put("qm", 1);
            map.put("ef", 2);
            map.put("qf", 3);
            map.put("sf", 4);
            map.put("f", 5);

            if(comp1.equals(comp2)) return Long.compare(matchNumber, t2.getMatchNumber());
            else return Integer.compare(map.get(comp1), map.get(comp2));
        } else if(type == SortingType.DATE) {
            return Long.compare(time, t2.getTime());
        }

        throw new RuntimeException("Unsupported sorting type for match model.");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCompLevel() {
        return compLevel;
    }

    public void setCompLevel(String compLevel) {
        this.compLevel = compLevel;
    }

    public long getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(long setNumber) {
        this.setNumber = setNumber;
    }

    public long getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(long matchNumber) {
        this.matchNumber = matchNumber;
    }

    public MatchAlliance getBlue() {
        return blue;
    }

    public void setBlue(MatchAlliance blue) {
        this.blue = blue;
    }

    public MatchAlliance getRed() {
        return red;
    }

    public void setRed(MatchAlliance red) {
        this.red = red;
    }

    public String getWinningAlliance() {
        return winningAlliance;
    }

    public void setWinningAlliance(String winningAlliance) {
        this.winningAlliance = winningAlliance;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getPredictedTime() {
        return predictedTime;
    }

    public void setPredictedTime(long predictedTime) {
        this.predictedTime = predictedTime;
    }

    public long getActualTime() {
        return actualTime;
    }

    public void setActualTime(long actualTime) {
        this.actualTime = actualTime;
    }
}
