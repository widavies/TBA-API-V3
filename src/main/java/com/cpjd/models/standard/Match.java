package com.cpjd.models.standard;

import com.cpjd.models.ScoreBreakdown;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.cpjd.models.other.Media;
import com.cpjd.models.simple.SMatch;

/**
 * @since 1.0.0
 * @author Will Davies
 */

@EqualsAndHashCode(callSuper = false)
@Data
public class Match extends SMatch {
    /**
     * UNIX timestamp (seconds since 1-Jan-1970 00:00:00) when the match result was posted.
     */
    private long postResultTime;
    /**
     *
     Score breakdown for auto, teleop, etc. points. Varies from year to year. May be null.
     */
    private ScoreBreakdown redScoreBreakdown;
    private ScoreBreakdown blueScoreBreakdown;
    /**
     * Array of `Media` objects associated with this match.
     */
    private Media[] videos;

}
