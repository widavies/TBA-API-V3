package models.standard;

import models.other.Media;
import models.simple.SMatch;

/**
 * @since 1.0.0
 * @author Will Davies
 */
public class Match extends SMatch {
    /**
     * UNIX timestamp (seconds since 1-Jan-1970 00:00:00) when the match result was posted.
     */
    private int postResultTime;
    /**
     *
     Score breakdown for auto, teleop, etc. points. Varies from year to year. May be null.
     */
    private String scoreBreakdown;
    /**
     * Array of `Media` objects associated with this match.
     */
    private Media[] videos;

}
