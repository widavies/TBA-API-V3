package com.cpjd.models.matches;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
public class MatchAlliance implements Serializable {
    /**
     * Score for this alliance. Will be null or -1 for an unplayed match.
     */
    private long score;
    /**
     * TBA Team keys (eg frc254) for teams on this alliance.
     */
    private String[] teamKeys;
    /**
     * TBA team keys (eg `frc254`) of any teams playing as a surrogate.
     */
    private String[] surrogateTeamKeys;

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String[] getTeamKeys() {
        return teamKeys;
    }

    public void setTeamKeys(String[] teamKeys) {
        this.teamKeys = teamKeys;
    }

    public String[] getSurrogateTeamKeys() {
        return surrogateTeamKeys;
    }

    public void setSurrogateTeamKeys(String[] surrogateTeamKeys) {
        this.surrogateTeamKeys = surrogateTeamKeys;
    }
}
