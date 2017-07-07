package models.other;

import lombok.Data;

/**
 *
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class APIStatus {
    /**
     * Year of the current FRC season.
     */
    private long currentSeason;
    /**
     * Maximum FRC season year for valid queries.
     */
    private long maxSeason;
    /**
     * True if the entire FMS API provided by FIRST is down.
     */
    private boolean isDatafeedDown;
    /**
     * An array of strings containing event keys of any active events that are no longer updating.
     */
    private String[] downEvents;
    private long iosMinAppVersion;
    private long iosLatestAppVersion;
    private long androidMinAppVersion;
    private long androidLatestAppVersion;


}
