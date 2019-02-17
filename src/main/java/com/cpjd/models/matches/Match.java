package com.cpjd.models.matches;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.cpjd.models.events.Media;

import java.util.HashMap;

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

     These are year specific, so it's up to you to determine what you'd like to fetch.

     */
    private HashMap<String, Object> redScoreBreakdown;
    private HashMap<String, Object> blueScoreBreakdown;
    /**
     * Array of `Media` objects associated with this match.
     */
    private Media[] videos;

}
