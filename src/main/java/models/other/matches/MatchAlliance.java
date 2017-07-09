package models.other.matches;

import lombok.Data;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
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
}
