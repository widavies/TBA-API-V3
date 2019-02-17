package com.cpjd.models;

import java.io.Serializable;

/**
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class APIStatus implements Serializable {
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

    public long getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(long currentSeason) {
        this.currentSeason = currentSeason;
    }

    public long getMaxSeason() {
        return maxSeason;
    }

    public void setMaxSeason(long maxSeason) {
        this.maxSeason = maxSeason;
    }

    public boolean isDatafeedDown() {
        return isDatafeedDown;
    }

    public void setDatafeedDown(boolean datafeedDown) {
        isDatafeedDown = datafeedDown;
    }

    public String[] getDownEvents() {
        return downEvents;
    }

    public void setDownEvents(String[] downEvents) {
        this.downEvents = downEvents;
    }

    public long getIosMinAppVersion() {
        return iosMinAppVersion;
    }

    public void setIosMinAppVersion(long iosMinAppVersion) {
        this.iosMinAppVersion = iosMinAppVersion;
    }

    public long getIosLatestAppVersion() {
        return iosLatestAppVersion;
    }

    public void setIosLatestAppVersion(long iosLatestAppVersion) {
        this.iosLatestAppVersion = iosLatestAppVersion;
    }

    public long getAndroidMinAppVersion() {
        return androidMinAppVersion;
    }

    public void setAndroidMinAppVersion(long androidMinAppVersion) {
        this.androidMinAppVersion = androidMinAppVersion;
    }

    public long getAndroidLatestAppVersion() {
        return androidLatestAppVersion;
    }

    public void setAndroidLatestAppVersion(long androidLatestAppVersion) {
        this.androidLatestAppVersion = androidLatestAppVersion;
    }
}
