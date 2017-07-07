package models.other.matches;

import lombok.Data;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class MatchAlliance {
    /**
     * Score for this alliance. Will be null or -1 for an unplayed match.
     */
    private int score;
    /**
     * TBA Team keys (eg frc254) for teams on this alliance.
     */
    private String[] teamKeys;
    /**
     * TBA team keys (eg `frc254`) of any teams playing as a surrogate.
     */
    private String[] surrogateTeamKeys;
}
