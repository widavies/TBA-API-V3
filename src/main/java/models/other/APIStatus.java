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
    private int currentSeason;
    /**
     * Maximum FRC season year for valid queries.
     */
    private int maxSeason;
    /**
     * True if the entire FMS API provided by FIRST is down.
     */
    private boolean isDatafeedDown;
    /**
     * An array of strings containing event keys of any active events that are no longer updating.
     */
    private String[] downEvents;
    private APIStatusAppVersion ios;
    private APIStatusAppVersion android;

    @Data
    private class APIStatusAppVersion {
        /**
         * Internal use - Minimum application version required to correctly connect and process data.
         */
        private int minAppVersion;
        /**
         * Internal use - Latest application version available.
         */
        private int latestAppVersion;
    }
}
